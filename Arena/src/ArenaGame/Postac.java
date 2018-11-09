package ArenaGame;

import java.util.Map;

public class Postac {
	
	private int akthp;
	private int maxhp;
	private int zloto;
	private int poziom;
	private int exp;
	private int napoje;
	
	public Postac() {
		akthp = 100;
		maxhp = 100;
		zloto = 60;
		poziom = 1;
		exp = 0;
		napoje = 3;
	}
	public Postac(Map<String, String> statystyki) {
		akthp = Integer.parseInt(statystyki.get("akthp"));
		maxhp = Integer.parseInt(statystyki.get("maxhp"));
		zloto = Integer.parseInt(statystyki.get("zloto"));
		poziom = Integer.parseInt(statystyki.get("poziom"));
		exp = Integer.parseInt(statystyki.get("exp"));
		napoje = Integer.parseInt(statystyki.get("napoje"));
	}
	
	
	public void czyAwansowal() {
		
		if(this.getExp()>this.getPoziom()*200 && this.getPoziom()<4) {
			setExp(0);
			setPoziom(getPoziom()+1);
			setMaxhp(getMaxhp()+25);
			System.out.println("Gratuacje, awansowales na kolejny poziom!");
		}else if(this.getExp()>this.getPoziom()*200 && this.getPoziom()==4) {
			setExp(0);
			setPoziom(getPoziom()+1);
			setMaxhp(getMaxhp()+25);
			System.out.println("Gratuacje, awansowales na maksymalny poziom!!!");
		}
	}
	
	public boolean czyTrafil(int szansa) {
		return this.poziom*15+20>szansa ? true:false;
	}
	
	public int getAkthp() {
		return akthp;
	}

	public void setAkthp(int akthp) {
		this.akthp = akthp;
	}

	public int getMaxhp() {
		return maxhp;
	}

	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}

	public int getZloto() {
		return zloto;
	}

	public void setZloto(int zloto) {
		this.zloto = zloto;
	}

	public int getPoziom() {
		return poziom;
	}

	public void setPoziom(int poziom) {
		this.poziom = poziom;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getNapoje() {
		return napoje;
	}

	public void setNapoje(int napoje) {
		this.napoje = napoje;
	}
	

}
