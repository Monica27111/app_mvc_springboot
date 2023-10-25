/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.app_mvc_springboot;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *
 * @author mydia
 */
@Controller
public class ArticuloControllers {
    
    @Autowired
    private RegistroRepository registroProducto;
    @GetMapping("")
    public String index(Model model){
        List<Articulo> articulo = registroProducto.findAll();
        model.addAttribute("articulo",articulo);
        return "index";
    }
    
    
    @GetMapping("/registroProducto")
    public String registro()
    { 
       return "registro";
    }
    @PostMapping("/enviaDatos")
    public String procesarFormulario(Articulo articulo) {
        registroProducto.save(articulo);
        return "registro"; // Retorna una vista de resultado
    }
    
}
