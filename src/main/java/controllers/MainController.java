package controllers;

import domain.Client;
import domain.Contract;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.MobileService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private MobileService service;

    @GetMapping({"/", "/index"})
    public String main(Model model) {
        List<Client> clients = service.getAllClients();
        List<String> output = new ArrayList<>();
        for (Client c: clients) {
            String line = c.getFirstName() + " " + c.getLastName();
            output.add(line);
        }
        model.addAttribute("exist", output);
        return "index";
    }

    @GetMapping("/contract")
    public String contract(Model model) {
        model.addAttribute("number", service.getContract().getNumber());
        model.addAttribute("tariff", service.getContract().getTariff().getName());
        model.addAttribute("options", service.getContract().getOptionsForTariff().get(0).getName());
        return "contract";
    }

    @GetMapping("/option")
    public String option(Model model) {
        model.addAttribute("name", service.getOption().getName());
        model.addAttribute("price", service.getOption().getPrice());
        model.addAttribute("connectionCost", service.getOption().getConnectionCost());
        return "option";
    }

    @GetMapping("/tariff")
    public String tariff(Model model) {
        model.addAttribute("name", service.getTariff().getName());
        model.addAttribute("price", service.getTariff().getPrice());
        model.addAttribute("options", service.getTariff().getOptions().get(0));
        return "tariff";
    }

    @GetMapping("/add")
    public String getadd() {
        return "add";
    }

    @PostMapping("/add")
    public String add(@RequestParam(name="firstName") String firstName,
                      @RequestParam(name="lastName") String lastName,
                      @RequestParam(name="birthDate") String birthDate,
                      @RequestParam(name="passportData") String passportData,
                      @RequestParam(name="address") String address,
                      @RequestParam(name="email") String email,
                      @RequestParam(name="password") String password) {
        String[] forDate = birthDate.split(" ");
        LocalDate date = LocalDate.of(Integer.parseInt(forDate[0]), Integer.parseInt(forDate[1]), Integer.parseInt(forDate[2]));
        Client client = new Client(firstName, lastName, date, passportData, address, email, password);
        client.setContracts(Arrays.asList(new Contract()));
        service.saveClient(client);
        return "redirect:/index";
    }

    @PostMapping("/search")
    public String search(@RequestParam(name="firstName") String firstName, Model model) {
        Integer id = Integer.parseInt(firstName);
        Client goal = service.getClientById(id);
        model.addAttribute("firstName", goal.getFirstName());
        model.addAttribute("lastName", goal.getLastName());
        model.addAttribute("birthDate", goal.getBirthDate());
        model.addAttribute("passportData", goal.getPassword());
        model.addAttribute("address", goal.getAddress());
        model.addAttribute("email", goal.getEmail());
        model.addAttribute("password", goal.getPassword());
        model.addAttribute("contract", goal.getContracts());
        return "search";
    }





}
