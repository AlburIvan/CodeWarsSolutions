package com.raworkstudio.codewars.breadcrumb_generator;

/**
 * Created by Ivan Alburquerque on 4/20/2017.
 */
public class BreadcrumbGenerator {


    class Freddin {

        public String name;
        public String apellido;


        public Freddin() {
        }

        public Freddin(String name, String apellido) {
            this.name = name;
            this.apellido = apellido;
        }

        public Freddin setName(String name) {
            this.name = name;
            return this;
        }

        public Freddin setApellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public Freddin createPerson() {
            return this;
        }
//        }
    }


    public String generate_bc(String site, String separator) {

        // http://www.mysite.com/pictures/holidays.html

        // <a href="/">HOME</a> : <a href="/pictures/">PICTURES</a> : <span class="active">HOLIDAYS</span>"


//        Freddin freddin = new Freddin();
//        freddin.setName("");
//        freddin.setApellido("");


        Freddin freddin = new Freddin()
                .setName("fredding")
                .setApellido("albur")
                .createPerson();






        Freddin f = new Freddin(){

            {
                name = "asdasdaa";
                apellido = "asdasd";
            }
        };





        return "";
    }
}
