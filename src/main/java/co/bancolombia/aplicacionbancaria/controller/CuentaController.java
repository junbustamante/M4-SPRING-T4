package co.bancolombia.aplicacionbancaria.controller;

import co.bancolombia.aplicacionbancaria.DTO.ConsultaCuentaDTO;
import co.bancolombia.aplicacionbancaria.DTO.CreaCuentaDTO;
import co.bancolombia.aplicacionbancaria.model.Cuenta;
import co.bancolombia.aplicacionbancaria.service.CuentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cuenta")
public class CuentaController {

    private final CuentaService cuentaService;

    public CuentaController(CuentaService cuentaService) {
        this.cuentaService = cuentaService;
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearCuenta(@Valid @RequestBody CreaCuentaDTO crearDTO) {
        cuentaService.save(crearDTO);
        return new ResponseEntity<>("Cuenta creada exitosamente", HttpStatus.CREATED);
    }

    @GetMapping("/saldo")
    public ResponseEntity<String> obtenerSaldo(@Valid @RequestBody ConsultaCuentaDTO consultaCuentaDTO) {
        Cuenta cuenta = cuentaService.obtenerSaldo(consultaCuentaDTO);
        return new ResponseEntity<>(cuenta.toString(), HttpStatus.OK);
    }

}
