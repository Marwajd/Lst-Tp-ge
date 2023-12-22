package Services;

import Modules.*;
import java.util.ArrayList;
public class Configuration {

        public static int DEPT_ID = 0;
        public static int ENS_ID = 0;
        public static int ETD_ID = 0;
        public static int FIL_ID = 0;
        public static int MOD_ID = 0;
        public static ArrayList<Departement> departements = new ArrayList<Departement>();
        public static ArrayList<Enseignant> enseignants = new ArrayList<Enseignant>();
        public static ArrayList<Filieres> filieres = new ArrayList<Filieres>();
        public static ArrayList<Modules> modules = new ArrayList<Modules>();
        public static ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
        public static ArrayList<Notes> notes = new ArrayList<Notes>();

        public  static int getDeptId(){
            DEPT_ID++;
            return DEPT_ID;
        }
        public  static int getEnsId(){
            ENS_ID++;
            return ENS_ID;
        }
    public  static int getEtdId(){
        ETD_ID++;
        return ETD_ID;
    }
    public  static int getFilId(){
        FIL_ID++;
        return FIL_ID;
    }
    public  static int getModId(){
        MOD_ID++;
        return MOD_ID;
    }
    }

