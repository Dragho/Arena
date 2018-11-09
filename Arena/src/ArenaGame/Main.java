package ArenaGame;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Main{
	
	private static void wczytywanie(Map<String, String> statystyki) throws IOException{
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.println("Podaj numer save'a");
			System.out.println("[1]");
			System.out.println("[2]");
			System.out.println("[3]");
			System.out.println("[4]");
			System.out.println("[5] aby wyjsc z programu");
			System.out.println("Twoj wybor:");
			int nrSave = in.nextInt();
			boolean wczytany = false;
		
			switch(nrSave) {
			case 1:
			{
				try {
					in = new Scanner(new File("plik1.txt"));
					while(in.hasNextLine()) {
						statystyki.put(in.next(), in.next());
					}
					in.close();
					Postac bohater = new Postac(statystyki);
					panelGlowny(statystyki,bohater);
					wczytany = true;
				} catch (FileNotFoundException e) {
					System.out.println("Plik nie istnieje");
				}
				
			}
			break;
			case 2:
			{
				try {
					in = new Scanner(new File("plik2.txt"));
					while(in.hasNextLine()) {
						statystyki.put(in.next(), in.next());
					}
					in.close();
					wczytany = true;
					Postac bohater = new Postac(statystyki);
					panelGlowny(statystyki,bohater);
				} catch (FileNotFoundException e) {
					System.out.println("Plik nie istnieje");
				}
				
			}
			break;
			case 3:
			{
				try {
					in = new Scanner(new File("plik3.txt"));
					while(in.hasNextLine()) {
						statystyki.put(in.next(), in.next());
					}
					in.close();
					wczytany = true;
					Postac bohater = new Postac(statystyki);
					panelGlowny(statystyki,bohater);
				} catch (FileNotFoundException e) {
					System.out.println("Plik nie istnieje");
				}
				
			}
			break;
			case 4:
			{
				try {
					in = new Scanner(new File("plik4.txt"));
					while(in.hasNextLine()) {
						statystyki.put(in.next(), in.next());
					}
					in.close();
					wczytany = true;
					Postac bohater = new Postac(statystyki);
					panelGlowny(statystyki,bohater);
				} catch (FileNotFoundException e) {
					System.out.println("Plik nie istnieje");
				}
				
			}
			break;
			case 5:
			{
				return;
			}
			default:
			{
				System.out.println("Blad wczytywania pliku");
			}
			}
			
		}	
		
	}
	
	private static void zapisywanie(Postac bohater) throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter(new File("plik1.txt")));
		String k = "akthp " + bohater.getAkthp();
		out.write(k);
		out.newLine();
		k = "maxhp " + bohater.getMaxhp();
		out.write(k);
		out.newLine();
		k = "zloto " + bohater.getZloto();
		out.write(k);
		out.newLine();
		k = "poziom " + bohater.getPoziom();
		out.write(k);
		out.newLine();
		k = "exp " + bohater.getExp();
		out.write(k);
		out.newLine();
		k = "napoje " + bohater.getNapoje();
		out.write(k);
		out.close();
	}
	
	private static void walka(Postac bohater, Przeciwnik przeciwnik, Scanner in) {
		//deklaracja zmiennych
		int wybor, szansaTrafienia,silaAtakuBohatera,szansaTrafieniaBohatera;
		Random rand = new Random();
		System.out.println("Witaj na arenie a teraz zmierz sie z przeciwnikiem!");
		
		while(bohater.getAkthp()>0 && przeciwnik.getAkthp()>0) {
			silaAtakuBohatera = rand.nextInt(21)+(bohater.getPoziom()*20);
			szansaTrafieniaBohatera = rand.nextInt(100)+1;
			System.out.println("Twoje hp = " + bohater.getAkthp());
			System.out.println("Hp przeciwnika = " + przeciwnik.getAkthp());
			System.out.println("Wybierz [1] aby zaatakowac");
			System.out.println("Wybierz [2] aby wypic miksture");
			wybor = in.nextInt();
			
			if(wybor == 1) {
				if(bohater.czyTrafil(szansaTrafieniaBohatera)) {
					System.out.printf("Atakujesz przeciwnika za %d punktow zycia!%n",silaAtakuBohatera);
					przeciwnik.setAkthp(przeciwnik.getAkthp()-silaAtakuBohatera);
				}
				else {
					System.out.println("Chybiasz!");
				}
			}
			else if(wybor == 2) {
				if(bohater.getNapoje()>0) {
					System.out.println("Wypiles miksture, czujesz sie duzo lepiej!");
					bohater.setNapoje(bohater.getNapoje()-1);
					bohater.setAkthp(bohater.getAkthp()+50);
					if(bohater.getAkthp()>bohater.getMaxhp())bohater.setAkthp(bohater.getMaxhp());
				}
			}
			else {
				System.out.println("Blad, sprobuj jeszcze raz!");
				continue;
			}
			szansaTrafienia = rand.nextInt(100)+1;
			if(przeciwnik.czyTrafil(szansaTrafienia)) {
				System.out.printf("Przeciwnik atakuje i skutecznie odbiera ci %d punktow zycia%n",przeciwnik.getSilaAtaku());
				bohater.setAkthp(bohater.getAkthp()-przeciwnik.getSilaAtaku());
			}
			else {
				System.out.println("Przeciwnik pudluje!");
			}
		}
		if(bohater.getAkthp()>0) {
			System.out.println("Gratulacje, pokonales przeciwnika!");
			System.out.printf("Zdobyles %d sztuk zlota%n",przeciwnik.getIloscZlota());
			System.out.printf("Zdobyles %d doswiadczenia%n", przeciwnik.getIloscDosw());
			bohater.setZloto(bohater.getZloto()+przeciwnik.getIloscZlota());
			bohater.setExp(bohater.getExp()+przeciwnik.getIloscDosw());
			bohater.czyAwansowal();
			
		}else {
			System.out.println("Niestety przegrales :C");
			return;
		}
	}
	
	private static void panelGlowny(Map<String, String> statystyki, Postac bohater) throws IOException {
		
		Scanner in = new Scanner(System.in);
		int wybor = 0;
		
		
		
		do{
			if(bohater.getAkthp()<=0) {
				return;
			}
			Random rand = new Random();
			int wylosowane = rand.nextInt(20)+10;
			System.out.printf("MAXHP:%d%nHP:%d%nPoziom:%d%nExp:%d%nZloto:%d%nMikstury:%d%n",bohater.getMaxhp(),bohater.getAkthp(),bohater.getPoziom(),bohater.getExp(),bohater.getZloto(),bohater.getNapoje());
			System.out.println("Wybierz opcje:");
			System.out.printf("[1] Udaj sie do tawerny i zregeneruj sily za %d sztuk zlota%n", wylosowane);
			System.out.println("[2] Kup miksture lecznicza za 50 sztuk zlota");
			System.out.println("[3] Udaj sie na arene i walcz ze slabym przeciwnikiem");
			System.out.println("[4] Udaj sie na arene i walcz z trudnym przeciwnikiem");
			System.out.println("[5] Udaj sie na arene i walcz z finalowym przeciwnikiem");
			System.out.println("[0] Aby wyjsc i zapisac gre");	
			wybor = in.nextInt();
			
			switch(wybor){
				case 1:
				{
					System.out.println("Witaj w tawernie!");
					
					if(bohater.getZloto()>= wylosowane) {
						System.out.println("Przespales sie i odzyskales sily");
						bohater.setZloto(bohater.getZloto()-wylosowane);
						bohater.setAkthp(bohater.getMaxhp());
					}else {
						System.out.println("Brakuje ci zlota..");
					}
				}
				break;
				case 2:
				{
					if(bohater.getZloto()>=50) {
						System.out.println("Kupiles miksture lecznicza");
						bohater.setZloto(bohater.getZloto() - 50);
						bohater.setNapoje(bohater.getNapoje() + 1);
					}else {
						System.out.println("Nie posiadasz wystarczajacej ilosci zlota!");
					}
				}
				break;
				case 3:
				{
					Przeciwnik przeciwnik = new Przeciwnik(1);
					walka(bohater, przeciwnik, in);
				}
				break;
				case 4:
				{
					Przeciwnik przeciwnik = new Przeciwnik(2);
					walka(bohater, przeciwnik, in);
				}
				break;
				case 5:
				{
					if(bohater.getPoziom() >= 3) {
						Przeciwnik przeciwnik = new Przeciwnik(3);
						walka(bohater, przeciwnik, in);
					}else {
						System.out.println("Potrzebujesz minimum 3 poziomu aby zmierzyc sie z tym przeciwnikiem");
					}
				}
				break;
				case 0:
				{
					zapisywanie(bohater);
					return;
				}
				
				default:
				{
					System.out.println("Zly wybor, sprobuj jeszcze raz!");
				}
			}
		}while(wybor != 0);
	}
	
	
	public static void main(String [] args) throws IOException {
		Scanner in = new Scanner(System.in);
		Map<String,String> statystyki = new HashMap<>();
		
		wczytywanie(statystyki);
		
		
		
		
		
	}
	
}
