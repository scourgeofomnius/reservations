package com.airline.reservations.payment;

import com.airline.reservations.flight.Search;
import com.airline.reservations.flight.flight;
import com.airline.reservations.flight.flightModel;
import com.airline.reservations.reservations.ReservationsModel;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Controller
public class paymentController {
    public final com.airline.reservations.flight.flightModel flightModel;
    public final ReservationsModel reservationsModel;
    public final paymentModel paymentModel;

    public List<String> sessioninfo = new ArrayList<String>();

    public paymentController(com.airline.reservations.flight.flightModel flightModel, ReservationsModel reservationsModel, com.airline.reservations.payment.paymentModel paymentModel) {
        this.flightModel = flightModel;
        this.reservationsModel = reservationsModel;
        this.paymentModel = paymentModel;
    }

    @PostMapping("/book")
    public String book(@ModelAttribute Search search, Model model, @Valid creditcard creditcard, BindingResult bindingResult, Authentication authentication) throws Exception{
        if(bindingResult.hasErrors()){
            return "searchflight";
        }
        String flightno = sessioninfo.get(0);
        String userid = authentication.getName();
        String credit = creditcard.getCc();
        String name = creditcard.getName();
        String date = creditcard.getDate();
        List<flight> bookedflight = flightModel.findByFlightno(flightno);
        reservationsModel.addreservation(userid, flightno);
        if(credit != null) {
            //Not going to enter payments yet into the database so commented out
            //paymentModel.addpayment(1L, 1L, credit);
            model.addAttribute("search", search);
            model.addAttribute("flight", bookedflight);
//            model.addAttribute("payment", payment);
            return "book";
        }
        else {
            return "paymt";
        }
    }
// Currently not workig for routining issues
//    @RequestMapping("/paymt")
//    public String tryagain(Model model){
//        Search search1 = new Search(sessioninfo.get(1), sessioninfo.get(2), sessioninfo.get(0));
//        model.addAttribute("search", search1);
//        model.addAttribute("payment", new creditcard());
//        return "paymt";
//    }

    @PostMapping("/paymt")
    public String book(@ModelAttribute Search search, Model model){
        sessioninfo.clear();
        sessioninfo.add(search.getSelected());
        sessioninfo.add(search.getDestination());
        sessioninfo.add(search.getOrigin());
        model.addAttribute("payment", new creditcard());
        return "paymt";
    }
}
