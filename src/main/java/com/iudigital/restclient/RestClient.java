package com.iudigital.restclient;

//import java.util.Arrays;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.iudigital.restclient.entity.ErrorMensaje;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import com.iudigital.restclient.entity.User;
import java.text.ParseException;
import java.util.ArrayList;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

public class RestClient {

    private static final String GET_ALL_USERS = "http://localhost:8005/api/user";
    private static final String GET_USER_BY_ID = "http://localhost:8005/api/user/{id}";
    private static final String CREATE_USER = "http://localhost:8005/api/user";
    private static final String UPDATE_USER = "http://localhost:8005/api/user/{id}";
    private static final String DELETE_USER = "http://localhost:8005/api/user/{id}";

    private static final RestTemplate REST_TEMPLATE = new RestTemplate();

    public static void main(String[] args) throws Exception {

        int rta;

        do {

            System.out.println("CLIENTE API RENTA-CAR");
            Scanner sc = new Scanner(System.in);
            Scanner tecla = new Scanner(System.in);

            System.out.println("Seleccione una de las siguientes opciones para un usuario:");
            System.out.println("1. Consultar");
            System.out.println("2. Guardar");
            System.out.println("3. Modificar");
            System.out.println("4. Eliminar");
            System.out.println("5. Ver usuario");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    try{
                        callGetUsers();
                    }catch (ParseException | JsonProcessingException ex) {
                        ex.printStackTrace();
                    }
                    break;
                case 2:
                    callCreateUser();
                    break;
                case 3:
                    callUpdateUser();
                    break;
                case 4:
                    callDeletedUser();
                    break;
                case 5:
                    callGetUserById();
                    break;

                default:
                    System.out.println("Seleccione una opción válida");
                    break;
            }

            System.out.print("\n¿Quiere seguir?\n");
            System.out.print("\nPresiona 1 para continuar...\n");

            rta = tecla.nextInt();

        } while (rta == 1);

    }

    private static void callGetUsers() throws ParseException, JsonProcessingException {

        try {
        ResponseEntity<List<User>> response = REST_TEMPLATE.exchange(
                GET_ALL_USERS,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<User>>() {
        });
        List<User> users = response.getBody();

        /*
        String json = new Gson().toJson(users);

        JsonParser parser = new JsonParser();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        JsonElement el = parser.parse(json);
        String jsonString = gson.toJson(el);

        System.out.println("Los usuarios registrados son:");

        //System.out.println(jsonString);
        System.out.println(jsonString);
        */
         ObjectMapper objectMapper = new ObjectMapper();
        
        String listJson = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(users); 
        
        System.out.println("Los usuario registrados son: ");
        System.out.println(listJson);
        } catch (Exception e) {
            escribirMensajeError(e); // replicar en los demas
        }

    }

    private static void callGetUserById() {

        System.out.println("Ingrese el id del usuario que quiere buscar:");
        Scanner ident = new Scanner(System.in);
        int ide = ident.nextInt();
        System.out.println("El id es: " + ide);
        System.out.println("--------------- ");

        Map<String, Integer> param = new HashMap<String, Integer>();
        param.put("id", ide);

        try {
        
        User user = REST_TEMPLATE.getForObject(GET_USER_BY_ID, User.class, param);

        System.out.println("Datos del usuario");
        System.out.println("Cedula: " + user.getCedula());
        System.out.println("Nombre: " + user.getNombre());
        System.out.println("Apellido: " + user.getApellido());
        System.out.println("Edad: " + user.getAge());
        System.out.println("Teléfono: " + user.getTelefono());
        System.out.println("Dirección: " + user.getDireccion());
        System.out.println("Barrio: " + user.getBarrio());
        System.out.println("Ciudad: " + user.getCiudad());
        System.out.println("Foto: " + user.getFoto());
        System.out.println("Reporte: " + user.isReporte());
        System.out.println("Password: " + user.getPass());
        System.out.println("Rol: " + user.getRol());
        System.out.println("----------------------");
        
        } catch (Exception e) {
            escribirMensajeError(e); // replicar en los demas
        }

    }

    private static void callCreateUser() {

        System.out.println("Ingrese los datos del usuario a guardar");
        User user = new User();

        Scanner nm = new Scanner(System.in);
        Scanner nom = new Scanner(System.in);
        Scanner ape = new Scanner(System.in);
        Scanner ed = new Scanner(System.in);
        Scanner tel = new Scanner(System.in);
        Scanner dir = new Scanner(System.in);
        Scanner bar = new Scanner(System.in);
        Scanner ciu = new Scanner(System.in);
        Scanner fot = new Scanner(System.in);
        Scanner rep = new Scanner(System.in);
        Scanner contr = new Scanner(System.in);
        Scanner idr = new Scanner(System.in);

        System.out.println("Digite la cédula: ");
        String cedula = nm.nextLine();
        System.out.println("La cédula es: " + cedula);
        System.out.println("--------------- ");

        System.out.println("Digite el nombre: ");
        String nombre = nom.nextLine();
        System.out.println("El apellido es: " + nombre);
        System.out.println("--------------- ");

        System.out.println("Digite el apellido: ");
        String apellido = ape.nextLine();
        System.out.println("El apellido es: " + apellido);
        System.out.println("--------------- ");

        System.out.println("Digite la edad: ");
        int edad = ed.nextInt();
        System.out.println("La edad es: " + edad);
        System.out.println("--------------- ");

        System.out.println("Digite la telefono: ");
        String telefono = tel.nextLine();
        System.out.println("El telefono es: " + telefono);
        System.out.println("--------------- ");

        System.out.println("Digite la direccion: ");
        String direccion = dir.nextLine();
        System.out.println("La direccion es: " + direccion);
        System.out.println("--------------- ");

        System.out.println("Digite el barrio: ");
        String barrio = bar.nextLine();
        System.out.println("El barrio es: " + barrio);
        System.out.println("--------------- ");

        System.out.println("Digite la ciudad: ");
        String ciudad = ciu.nextLine();
        System.out.println("La ciudad es: " + ciudad);
        System.out.println("--------------- ");

        System.out.println("Ingrese la url de la foto: ");
        String url = fot.nextLine();
        System.out.println("La URL es: " + url);
        System.out.println("--------------- ");

        System.out.println("Confirme si esta reportado (true-false): ");
        boolean reporte = rep.nextBoolean();
        System.out.println("El reporte es: " + reporte);
        System.out.println("--------------- ");

        System.out.println("Ingrese la clave: ");
        String pass = contr.nextLine();
        System.out.println("La clave es: " + pass);
        System.out.println("--------------- ");

        System.out.println("Ingrese el rol: ");
        String rol = idr.nextLine();
        System.out.println("El rol es: " + rol);
        System.out.println("--------------- ");

        user.setCedula(cedula);
        user.setNombre(nombre);
        user.setApellido(apellido);
        user.setAge(edad);
        user.setTelefono(telefono);
        user.setDireccion(direccion);
        user.setBarrio(barrio);
        user.setCiudad(ciudad);
        user.setFoto(url);
        user.setReporte(reporte);
        user.setPass(pass);
        user.setRol(rol);

        try{
        
        ResponseEntity<Void> user2 = REST_TEMPLATE.postForEntity(CREATE_USER, user, Void.class);

        System.out.println(user2.getStatusCode());
        System.out.println("Usuario guardado con éxito");
        } catch (Exception e) {
            escribirMensajeError(e); // replicar en los demas
        }

    }

    private static void callUpdateUser() {
        System.out.println("Ingrese el id del usuario que quiere actualizar:");
        Scanner ident = new Scanner(System.in);
        int ide = ident.nextInt();
        System.out.println("El id es: " + ide);
        System.out.println("--------------- ");

        Map< String, Integer> params = new HashMap< String, Integer>();
        params.put("id", ide);
        
        System.out.println("Ingrese los nuevos datos:");
        User updatedUser = new User();

        Scanner nm = new Scanner(System.in);
        Scanner nom = new Scanner(System.in);
        Scanner ape = new Scanner(System.in);
        Scanner ed = new Scanner(System.in);
        Scanner tel = new Scanner(System.in);
        Scanner dir = new Scanner(System.in);
        Scanner bar = new Scanner(System.in);
        Scanner ciu = new Scanner(System.in);
        Scanner fot = new Scanner(System.in);
        Scanner rep = new Scanner(System.in);
        Scanner pas = new Scanner(System.in);
        Scanner idr = new Scanner(System.in);

        System.out.println("Digite la cédula: ");
        String cedula = nm.nextLine();
        System.out.println("La cédula es: " + cedula);
        System.out.println("--------------- ");

        System.out.println("Digite el nombre: ");
        String nombre = nom.nextLine();
        System.out.println("El apellido es: " + nombre);
        System.out.println("--------------- ");

        System.out.println("Digite el apellido: ");
        String apellido = ape.nextLine();
        System.out.println("El apellido es: " + apellido);
        System.out.println("--------------- ");

        System.out.println("Digite la edad: ");
        int edad = ed.nextInt();
        System.out.println("La edad es: " + edad);
        System.out.println("--------------- ");

        System.out.println("Digite la telefono: ");
        String telefono = tel.nextLine();
        System.out.println("El telefono es: " + telefono);
        System.out.println("--------------- ");

        System.out.println("Digite la direccion: ");
        String direccion = dir.nextLine();
        System.out.println("La direccion es: " + direccion);
        System.out.println("--------------- ");

        System.out.println("Digite el barrio: ");
        String barrio = bar.nextLine();
        System.out.println("El barrio es: " + barrio);
        System.out.println("--------------- ");

        System.out.println("Digite la ciudad: ");
        String ciudad = ciu.nextLine();
        System.out.println("La ciudad es: " + ciudad);
        System.out.println("--------------- ");

        System.out.println("Ingrese la url de la foto: ");
        String url = fot.nextLine();
        System.out.println("La URL es: " + url);
        System.out.println("--------------- ");

        System.out.println("Confirme si esta reportado (true-false): ");
        boolean reporte = rep.nextBoolean();
        System.out.println("El reporte es: " + reporte);
        System.out.println("--------------- ");

        System.out.println("Ingrese la contraseña: ");
        String contr = pas.nextLine();
        System.out.println("La clave es: " + contr);
        System.out.println("--------------- ");

        System.out.println("Ingrese el rol del usuario ");
        String rol = idr.nextLine();
        System.out.println("La rol es: " + rol);
        System.out.println("--------------- ");

        updatedUser.setCedula(cedula);
        updatedUser.setNombre(nombre);
        updatedUser.setApellido(apellido);
        updatedUser.setAge(edad);
        updatedUser.setTelefono(telefono);
        updatedUser.setDireccion(direccion);
        updatedUser.setBarrio(barrio);
        updatedUser.setCiudad(ciudad);
        updatedUser.setFoto(url);
        updatedUser.setReporte(reporte);
        updatedUser.setPass(contr);
        updatedUser.setRol(rol);

        try {
        
        REST_TEMPLATE.put(UPDATE_USER, updatedUser, params);

        System.out.println("Usuario actualizado con éxito");
        } catch (Exception e) {
            escribirMensajeError(e); // replicar en los demas
        }
    }

    private static void callDeletedUser() throws JsonProcessingException {

        System.out.println("Ingrese el id del usuario que quiere eliminar:");
        Scanner ident = new Scanner(System.in);
        int ide = ident.nextInt();
        System.out.println("El id es: " + ide);
        System.out.println("--------------- ");

        Map<String, Integer> params = new HashMap<>();
        params.put("id", ide);
        try {
            
            REST_TEMPLATE.delete(DELETE_USER, params);

            System.out.println("Usuario borrado con éxito");
        } catch (Exception e) {
            escribirMensajeError(e); // replicar en los demas
        }

    }

    private static void escribirMensajeError(Exception e) {
        
        if (e.getMessage().toUpperCase().contains("CONNECTION")) {
            
            System.out.println("Error en conexión");
            
        } else if (e instanceof HttpClientErrorException) {
            
            HttpClientErrorException clientErrorException = (HttpClientErrorException) e;

            if (clientErrorException instanceof HttpClientErrorException.BadRequest) {

                HttpClientErrorException.BadRequest badRequest = (HttpClientErrorException.BadRequest) clientErrorException;
                System.out.println(badRequest.getResponseBodyAsString()); // convertir a objeto java
                
                
            } else if (clientErrorException instanceof HttpClientErrorException.NotFound) {
                // TODO: SI HAY OTRA EXCEPCION
            } else {

                System.out.println("Error en el servidor");

            }

        } else {
            System.out.println(e.getMessage());
        }
        
    }

}

//prueba