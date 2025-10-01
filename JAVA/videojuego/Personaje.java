public abstract class Personaje {
        private String nombre;
        private int vida;
        private int fuerza;
        private int destreza;
        private int inteligencia;
        private int experiencia;
        private int nivel;
        private Objeto[] equipo;
        private static int personajesCreados = 0;


        public Personaje(String nombre, int vida, int fuerza, int destreza, int inteligencia) {
            this.nombre = nombre;
            this.vida = vida;
            this.fuerza = fuerza;
            this.destreza = destreza;
            this.inteligencia = inteligencia;
            this.experiencia = 0;
            this.nivel = 1;
            this.equipo = new Objeto[3];
            personajesCreados++;
        }

        public Personaje() {
            this.nombre="Personaje1";
            this.vida=100;
            this.fuerza=10;
            this.destreza=10;
            this.inteligencia=10;
            personajesCreados++;
        }


        public String getNombre() {
            return nombre;
        }
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public int getVida() {
            return vida;
        }
        public void setVida(int vida) {
            this.vida = vida;
        }

        public int getFuerza() {
            return fuerza;
        }
        public void setFuerza(int fuerza) {
            this.fuerza = fuerza;
        }

        public int getDestreza() {
            return destreza;
        }
        public void setDestreza(int destreza) {
            this.destreza = destreza;
        }

        public int getInteligencia() {
            return inteligencia;
        }
        public void setInteligencia(int inteligencia) {
            this.inteligencia = inteligencia;
        }

        public int getExperiencia() {
            return experiencia;
        }
        public void setExperiencia(int experiencia) {
            this.experiencia = experiencia;
        }

        public int getNivel() {
            return nivel;
        }
        public void setNivel(int nivel) {
            this.nivel = nivel;
        }

        public Objeto[] getEquipo() {
            return equipo;
        }

        @Override
        public String toString() {
            return "Personaje: " +
                    "nombre='" + this.nombre + ", vida=" + this.vida + ", fuerza=" + this.fuerza + ", destreza=" + this.destreza + ", inteligencia=" + this.inteligencia + ", experiencia=" + this.experiencia + ", nivel=" + this.nivel;
        }


        public void recibirDaño(int daño) {
            this.vida -= daño;
        }


        public void ganarExperiencia(int experiencia) {
            this.experiencia += experiencia;
            this.nivel = (int) Math.sqrt(this.experiencia);
        }


        public void equipar(Objeto objeto) {
            for (int i = 0; i < 3; i++) {
                if (equipo[i] == null) {
                    equipo[i] = objeto;
                    break;
                }
            }
        }

        public static int getPersonajesCreados() {
            return personajesCreados;
        }
}


