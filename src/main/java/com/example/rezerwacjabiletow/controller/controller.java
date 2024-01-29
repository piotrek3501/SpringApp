package com.example.rezerwacjabiletow.controller;

import com.example.rezerwacjabiletow.models.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.Clock;
import java.time.LocalDate;
import java.util.*;

@Controller
@SessionAttributes(value={"Flight","LuggageLimit"})
public class controller {
    private final FlightController flightController;
    private final LuggageController luggageController;
    private  final CombinationController combinationController;
    private final PlaceController placeController;
    private final RoleController roleController;
    private final UserController userController;
    private final AdressController adressController;
    private final CountryController countryController;
    private final CityController cityController;
    private final FlightclassController flightclassController;
    private final SeatController seatController;
    private final BookingController bookingController;
    private final UserForBookController userForBookController;



    public controller(FlightController flightController, LuggageController luggageController, CombinationController combinationController, PlaceController placeController, RoleController roleController, UserController userController, AdressController adressController, CountryController countryController, CityController cityController, FlightclassController flightclassController, SeatController seatController, BookingController bookingController, UserForBookController userForBookController) {
        this.flightController = flightController;
        this.luggageController = luggageController;
        this.combinationController = combinationController;
        this.placeController = placeController;
        this.roleController = roleController;
        this.userController = userController;
        this.adressController = adressController;
        this.countryController = countryController;
        this.cityController = cityController;
        this.flightclassController = flightclassController;
        this.seatController = seatController;
        this.bookingController = bookingController;
        this.userForBookController = userForBookController;
    }

    @GetMapping("/flightList")
    public String createListFlight(Model model,Model params)throws Exception{
            model.addAttribute("List", flightController.returnAll());
            params.addAttribute("SearchParamsModel",new Parameters());
        return "flightList";
    }
    @PostMapping("/flightList")
    public String searchInFlights(@Valid @ModelAttribute("List")ArrayList<Flight>list,@Valid @ModelAttribute("SearchParamsModel")Parameters params,BindingResult result)throws Exception{
        List<Flight> updatedList = flightController.searchAndReturn(params);
        list.clear();
        list.addAll(updatedList);
        return "flightList";
    }
    @RequestMapping("/index")
    public String BackToMainPage() throws Exception{
        return "index";
    }
    @PostMapping(path="/admin/AddOrEditForm")
    public String processForm(@Valid @ModelAttribute("Flight")Flight  flightmodel, BindingResult result) throws Exception{

        if(result.hasErrors()){
            return "/admin/AddOrEditForm";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserDetails) authentication.getPrincipal();
        placeController.savePlace(flightmodel.getFrom());
        placeController.savePlace(flightmodel.getTo());
        combinationController.saveCombination(flightmodel.getCombination());
        flightmodel.setLuggageLimit(luggageController.findById(flightmodel.getLuggageLimit().getId()));
        //luggageController.saveLuggage(flightmodel.getLuggageLimit());
        flightmodel.setDate_adding(LocalDate.now(Clock.systemUTC()));
        flightmodel.setModerator(userController.findByUsername(user.getUsername()));
        flightController.saveFlight(flightmodel);
        return "redirect:/flightList";
    }

    @GetMapping("/admin/AddOrEditForm")
    public String showForm(@RequestParam(value="Id", required=false, defaultValue="1")Long id,Model model)throws Exception{

            if(flightController.isExistRecord(id)){
                model.addAttribute("Flight", flightController.getRecord(id));
            }else{
                model.addAttribute("Flight",new Flight());
            }

        return "/admin/AddOrEditForm";
    }
    @RequestMapping("admin/LuggageLimitList")
    public String showList(Model model){
        model.addAttribute("LuggageLimit",luggageController.returnAll());
        return "admin/LuggageLimitList";
    }
    @PostMapping(path="/admin/LuggageLimitAddOrEdit")
    public String processFormLuggage( @Valid @ModelAttribute("luggage")Luggage  luggageModel, BindingResult result) throws Exception{

        if(result.hasErrors()){
            //return "/admin/AddOrEditForm";
        }

        luggageController.saveLuggage(luggageModel);
        return "redirect:/admin/LuggageLimitList";
    }

    @GetMapping("/admin/LuggageLimitAddOrEdit")
    public String showFormLuggage(@RequestParam(value="Id", required=false, defaultValue="1")Long id,Model model)throws Exception{

        if(luggageController.isExistRecord(id)){
            model.addAttribute("luggage", luggageController.getRecord(id));
        }else{
            model.addAttribute("luggage",new Luggage());
        }

        return "admin/LuggageLimitAddOrEdit";
    }

    @ModelAttribute("LuggageLimitModel")
    public List<Luggage>loadLuggageLimit() throws Exception{
        List<Luggage>luggageList=luggageController.returnAll();
        return luggageList;
    }
    @ModelAttribute("SearchParamsModel")
    public Parameters loadSearchParams() {
        Parameters parameters=new Parameters();
        return parameters;
    }
    @ModelAttribute("FlightClasses")
    public List<Flightclass>FlightClassLoad(){

        return flightclassController.returnAll();
    }
    @ModelAttribute("Type")
    public List<String>loadConfirmType() throws Exception{

        List<String>TypeList=new ArrayList<>();
        String YesOption=new String("Tak");
        String NoOption=new String("Nie");
        TypeList.add(YesOption);
        TypeList.add(NoOption);

        return TypeList;
    }
    @ModelAttribute("currentDate")
    public LocalDate getCurrentDate() {
        return LocalDate.now();
    }

    @GetMapping("/admin/DeletingFlight")
    public String RemoveFlightForm(@RequestParam(value="Id", required=false, defaultValue="1")Long id,Model flightRemoving){

        flightRemoving.addAttribute("flightRemove",flightController.getRecord(id));

        return "/admin/DeletingFlight";
    }
    @PostMapping("/admin/DeletingFlight")
    public String RemovingFlight(@Valid @ModelAttribute("flightRemove")Flight flightRemoving,Model info, BindingResult result)throws Exception{

        if(flightController.isExistRecord(flightRemoving.getId())){
            flightController.removeFlight(flightRemoving.getId());
            info.addAttribute("info","Pomyślnie usunięto lot");
        }else{
            info.addAttribute("info","Nie można usunać lotu ponieważ on już nie istnieje");
        }

        return "/admin/ResultFormView";
    }
    @GetMapping("/signup")
    public String SignUpForm(Model UserData) throws Exception{
        UserData.addAttribute("User",new User());
        return "/signup";
    }
    @PostMapping(path = "/signup")
    public String SignUpProcess(@Valid @ModelAttribute("User")User user ,BindingResult result) throws Exception{

        if(result.hasErrors()){
            return "/signup";
        }
        if(userController.findByUsername(user.getUsername())!=null){
            result.rejectValue("username","registrationForm.username.not.unique");
            return "/signup";
        }else {

            if(user.getPassword().equals(user.getPasswordConfirm())){
                user.setEnabled(true);
                user.setRoles(new HashSet<>(Arrays.asList(roleController.initUser())));
                cityController.saveCity(user.getAdress().getCity());
                countryController.saveCountry(user.getAdress().getCountry());
                adressController.saveAdress(user.getAdress());
                userController.saveUser(user);
            }else{
                result.rejectValue("passwordConfirm","registrationForm.passwords.are.diffrent");
                return "/signup";
            }
        }
        return "login";
    }
    @GetMapping("/mkOrder")
    public String mkOrderForm(@RequestParam(value="Id", required=true, defaultValue="7")Long id,Model reservation,Model FirstClsSeatFree,Model BussinesClsSeatFree,
                              Model EconomicalClsSeatFree){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserDetails) authentication.getPrincipal();

        Booking book=new Booking();
        book.setFlight(flightController.getRecord(id));

        book.setUser(userController.findByUsername(user.getUsername()));
        reservation.addAttribute("reservation",book);

        List<Integer>NumFirstClsSeatFree=new ArrayList<>();
        List<Integer>NumBussinesClsSeatFree=new ArrayList<>();
        List<Integer>NumEconomicalClsSeatFree=new ArrayList<>();

        for(Integer i=1;i<=flightController.getRecord(id).getCombination().getFirst_cls_seats();i++) {
            NumFirstClsSeatFree.add(i);
        }
        for(Integer i=1;i<=flightController.getRecord(id).getCombination().getBussines_seats();i++) {
            NumBussinesClsSeatFree.add(i);
        }
        for(Integer i=1;i<=flightController.getRecord(id).getCombination().getEconomical_seats();i++) {
            NumEconomicalClsSeatFree.add(i);
        }

        for (Seat s : seatController.getReservedSeatsFrClass(id)) {
               if(NumFirstClsSeatFree.contains(s.getFirstClsSeatnumber())){
                   NumFirstClsSeatFree.remove(s.getFirstClsSeatnumber());
               }
        }

        for (Seat s : seatController.getReservedSeatBusClass(id)) {
            if(NumBussinesClsSeatFree.contains(s.getBusinessClsSeatnumber())){
                NumBussinesClsSeatFree.remove(s.getBusinessClsSeatnumber());
            }
        }

        for (Seat s : seatController.getReservedSeatEcoClass(id)) {
            if(NumEconomicalClsSeatFree.contains(s.getEconomicalClsSeatnumber())){
                NumEconomicalClsSeatFree.remove(s.getEconomicalClsSeatnumber());
            }
        }
        FirstClsSeatFree.addAttribute("FirstClsSeatFree",NumFirstClsSeatFree);
        BussinesClsSeatFree.addAttribute("BussinesClsSeatFree",NumBussinesClsSeatFree);
        EconomicalClsSeatFree.addAttribute("EconomicalClsSeatFree",NumEconomicalClsSeatFree);
       // choice.addAttribute("choice",Integer.valueOf(0));

        return "/mkOrder";
    }
    @PostMapping(path = "/mkOrder")
    public String mkOrderProcess(@Valid @ModelAttribute("reservation")Booking book,BindingResult result) throws Exception {
        if(result.hasErrors()){
            return "/mkOrder";
        }
        if(seatController.checkSeatInFlight(book.getFlight().getId(),book)) {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetails user = (UserDetails) authentication.getPrincipal();

            book.setUser(userController.findByUsername(user.getUsername()));
            book.setFlight(flightController.getRecord(book.getFlight().getId()));
            book.getBookSeat().setFlight(book.getFlight());
            if (book.getFlight().getDate().isBefore(LocalDate.now())) {
                book.setStatus(false);
            } else {
                book.setStatus(true);
            }
            book.getBookSeat().setUser(userController.findByUsername(user.getUsername()));
            seatController.save(book.getBookSeat());
            bookingController.save(book);

        }
        else{
            result.rejectValue("bookSeat.seatnumber","Reservation.bookSeat.seatnumber.notfree");
            return "/mkOrder";
        }

    return "redirect:/MyReservations";
    }
    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/login?logout";
    }
    @GetMapping("/MyReservations")
    public String DisplayReservationList(Model ListReservation)throws Exception{
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails user = (UserDetails) authentication.getPrincipal();
        ListReservation.addAttribute("ReservationList",bookingController.returnListBooking(userController.findByUsername(user.getUsername()).getId()));
        return "/MyReservations";
    }


}
