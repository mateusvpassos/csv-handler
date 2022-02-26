package br.com.mateus.csvhandler.endpoint.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import br.com.mateus.csvhandler.endpoint.domain.User;
import br.com.mateus.csvhandler.endpoint.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/export")
    public ResponseEntity<Void> exportToCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        String fileName = "users.csv";

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + fileName;

        response.setHeader(headerKey, headerValue);

        List<User> users = userService.findAll();
        ICsvBeanWriter csvWrite = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
        String[] csvHeader = { "ID", "NAME", "BIRTH DATE", "EMAIL", "PHONE", "ADDRESS", "CITY", "STATE", "COUNTRY",
                "ZIP CODE" };
        String[] names = { "id", "name", "birthDate", "email", "phone", "address", "city", "state", "country",
                "zipCode" };

        csvWrite.writeHeader(csvHeader);
        for (User user : users) {
            csvWrite.write(user, names);
        }

        csvWrite.close();
        return ResponseEntity.noContent().build();
    }
}
