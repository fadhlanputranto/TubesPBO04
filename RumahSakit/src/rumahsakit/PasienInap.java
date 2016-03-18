/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rumahsakit;

/**
 *
 * @author Asus A450CA
 */
public class PasienInap {
    private Pasien pasien;
    private Dokter dokter;
    private String[] diagnosa = new String[20];
    private int nDiagnosa;

    public PasienInap() {
    }
    
    public PasienInap(Pasien p, Dokter d) {
        pasien = p;
        setDokter(d);
    }

    public void addDiagnosa(String diagnosa) {
        if(nDiagnosa < 20){
            this.diagnosa[nDiagnosa] = diagnosa;
            nDiagnosa++;
        }else System.out.println("Penuh");    
    }
    
    public void setDokter(Dokter d) {
        dokter = d;
    }
    
    public Dokter getDokter() {
        return dokter;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public int getnDiagnosa() {
        return nDiagnosa;
    }

    public String getDiagnosa(int i) {
        return diagnosa[i];
    }
    
    public void deleteDiagnosa(int i){
        if(diagnosa[i+1]==null){
            diagnosa[i]=null;
            nDiagnosa = nDiagnosa-1;
        }else {
            for(int j = i;j<nDiagnosa;j++){
                diagnosa[j]=diagnosa[j+1];
                nDiagnosa = nDiagnosa-1;
            }
        }
        
    }
}
