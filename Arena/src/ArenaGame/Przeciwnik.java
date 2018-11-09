package ArenaGame;

import java.util.Random;

public class Przeciwnik {
	private int akthp;
	private int silaAtaku;
	private int iloscDosw;
	private int iloscZlota;
	private int rodzajPrzeciwnika;
	
	public Przeciwnik(int liczba){
		Random rand = new Random();
		switch(liczba) {
		case 1:
		{
			this.akthp = rand.nextInt(10) + 80;
			this.silaAtaku = rand.nextInt(10) + 10;
			this.iloscDosw = rand.nextInt(60) + 80;
			this.iloscZlota = rand.nextInt(20) + 30;
			this.rodzajPrzeciwnika = 1;
		}
		break;
		case 2:
		{
			this.akthp = rand.nextInt(20) + 120;
			this.silaAtaku = rand.nextInt(20) + 30;
			this.iloscDosw = rand.nextInt(100) + 160;
			this.iloscZlota = rand.nextInt(40) + 80;
			this.rodzajPrzeciwnika = 2;
		}
		break;
		case 3:
		{
			this.akthp = rand.nextInt(1) + 300;
			this.silaAtaku = rand.nextInt(30) + 60;
			this.iloscDosw = rand.nextInt(100) + 400;
			this.iloscZlota = rand.nextInt(1) + 300;
			this.rodzajPrzeciwnika = 3;
		}
		}
	}
	public boolean czyTrafil(int szansaTrafienia) {
		if(this.rodzajPrzeciwnika == 1 && szansaTrafienia>=60) {
			return true;
		}
		else if(this.rodzajPrzeciwnika == 2 && szansaTrafienia>=35) {
			return true;
		}
		else if(this.rodzajPrzeciwnika == 3 && szansaTrafienia>=10) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public int getIloscDosw() {
		return iloscDosw;
	}


	public void setIloscDosw(int iloscDosw) {
		this.iloscDosw = iloscDosw;
	}


	public int getIloscZlota() {
		return iloscZlota;
	}


	public void setIloscZlota(int iloscZlota) {
		this.iloscZlota = iloscZlota;
	}


	public int getAkthp() {
		return akthp;
	}

	public void setAkthp(int akthp) {
		this.akthp = akthp;
	}

	public int getSilaAtaku() {
		return silaAtaku;
	}

	public void setSilaAtaku(int silaAtaku) {
		this.silaAtaku = silaAtaku;
	}


}
