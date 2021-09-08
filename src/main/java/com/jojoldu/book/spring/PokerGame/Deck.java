package com.jojoldu.book.spring.PokerGame;

public class Deck {
	String [] Card = new String [52];
	String [] Card_num = new String [52];
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	// 카드 덱 초기화
	public void Newly(String[] Card){
		for (int i = 0; i < Card.length; i++) {
			int num = i + 1;
			int sort = num % 13;

			String number = Integer.toString(sort);
			Card[i] = number;
		}
	}

	// 카드 숫자 문자로 변형
	public void Convert(String x, int y, int z) {

		for (int i = y; i < z; i++) {

			if (Card[i].equals("11")) {
				Card[i] = "J";
			} else if (Card[i].equals("12")) {
				Card[i] = "Q";
			} else if (Card[i].equals("0")) {
				Card[i] = "K";
			} else if (Card[i].equals("1")) {
				Card[i] = "A";
			}
			Card[i] = Card[i] + x;

		}
	}

	// 문자를 숫자로 변형
	public void change(String[] Deck) {
		for (int x = 0; x < Deck.length; x++) {
			if (Deck[x].equals("J")) {
				Deck[x] = "11";

			} else if (Deck[x].equals("Q")) {
				Deck[x] = "12";

			} else if (Deck[x].equals("K")) {
				Deck[x] = "13";

			} else if (Deck[x].equals("A")) {
				Deck[x] = "14";

			} else if (Deck[x].equals("1")) {
				Deck[x] = "10";

			}

		}
	}

	// 랜덤 자리수의 덱 뽑기
	public String Shuf(String[] Card) {

		int random = (int) (Math.random() * 51 + 1);
		return Card[random];
	}
	// 카드 중복제거
	public void dis(String[] deck) {

		for (int i = 0; i < deck.length; i++) {
			deck[i] = Shuf(Card);

			for (int j = 0; j < i; j++) {
				if (deck[i] == deck[j]) {
					i--;
				}
			}

		}

	}

	// 본덱 카드 중복 제거
	public String newcard(String [] deck,String[] deck1) {
		String card="";
		for (int i = 0; i <2; i++) {
			card = Shuf(Card);

			for (int j = 0; j < 7; j++) {
				if (deck[j] == card) {
					i--;
				}
			}


		}

		for (int i = 0; i <2; i++) {
			card = Shuf(Card);


			for (int j = 0; j < 7; j++) {
				if (deck1[j] == card) {
					i--;
				}
			}


		}



		return card;

	}

	// 덱의 문양 과 숫자 분리
	public void caedc(String[] Deck, String[] Deckc, String[] Deckz) {

		for (int x = 0; x < Deck.length; x++) {

			Deckc[x] = Deck[x].substring(0, 1);
			Deckz[x] = Deck[x].substring(1, 2);
			if(Deck[x].substring(0,1).equals("1")) {
				Deckc[x] ="10";
				Deckz[x] = Deck[x].substring(2,3);
			}

		}
	}

	// 덱 디스플레이
	public void Deckdis(String [] Deck){
		for(int x=0; x<Deck.length;x++) {
			System.out.print(Deck[x]+" ");
		}
		System.out.println("");
	}


	// 덱 평가값 생성
	public String rechan(double num) {
		String d="";
		double c =(int)num;
		double per = Double.parseDouble(String.format("%.1f",num));
		double q = per -c;
		double t =Double.parseDouble(String.format("%.1f",q));

		if((int)num == 11) {
			d = "J";
		}else if((int)num == 12) {
			d="Q";
		}else if((int)num == 13) {
			d="K";
		}else if((int)num == 14) {
			d="A";
		}else if((int)num == 1) {
			d="10";
		}else {
			d = num+"";
			d = d.substring(0,1);
		}
		if( t ==0.1) {
			d = d+"♣";
		}else if(t == 0.2) {
			d= d+ "♥";
		}else if(t == 0.3) {
			d= d+ "◆";
		}else if(t == 0.4) {
			d= d+ "♠";
		}

		return d;

	}

	// 문자를 숫자열로 변경
	public void convert(String[] Decka,String [] Deckb, double [] Deck_int) {
		for (int x = 0; x < Decka.length; x++) {
			Deck_int[x] = Double.parseDouble(Decka[x]);
			if(Deckb[x].equals( "♣")) {
				Deck_int[x] = Deck_int[x] +0.1;
			}else if(Deckb[x].equals("♥")) {
				Deck_int[x] = Deck_int[x]+ 0.2;
			}else if(Deckb[x].equals("◆")) {
				Deck_int[x] = Deck_int[x]+ 0.3;
			}else if(Deckb[x].equals("♠")) {
				Deck_int[x] = Deck_int[x]+ 0.4;
			}


		}
	}
	// 덱을 숫자 기준으로 정렬
	public double sort(double [] char1) {


		for(int x=1;x <char1.length; x++) {
			double standard =char1[x]; int aux = x -1;
			while(aux >= 0 && standard < char1[aux]) {
				char1 [aux+1] =char1[aux]; aux --;
			}
			char1 [aux+1] =(double) standard;;

		} double num = char1[6];

		return num;
	}
	// 덱을 문양 기준으로 정령
	public double [] sort1(double [] char1) {


		for(int x=1;x <char1.length; x++) {
			double standard =char1[x]; int aux = x -1;
			while(aux >= 0 && standard < char1[aux]) {
				char1 [aux+1] =char1[aux]; aux --;
			}
			char1 [aux+1] =(double) standard;;

		}
		return new double[] {};
	}

	//오픈 카드
	public String  opens(int open,String [] Deck1,String open1) {
		if(open ==1) {
			System.out.println(Deck1[0]);
			open1 =Deck1[0];
		}else if (open ==2) {
			System.out.println(Deck1[1]);
			open1 =Deck1[1];
		}else if (open ==3) {
			System.out.println(Deck1[2]);
			open1 =Deck1[2];
		}

		return open1;
	}

	// 버릴 카드 뽑기
	public void drop(int drop, String [] Deck1){
		if(drop == 1) {
			System.out.println(" "+ Deck1[drop-1] +" 카드를 버리셨습니다");
			Deck1[0]= Deck1[1];
			Deck1[1] =Deck1[2];
			Deck1[2] = Deck1[3];
			Deck1[3]="";
		}else if(drop ==2) {
			System.out.println(" "+Deck1[drop-1] +" 카드를 버리셨습니다");

			Deck1[1] =Deck1[2];
			Deck1[2] = Deck1[3];
			Deck1[3]="";
		}else if(drop ==3) {
			System.out.println(" "+Deck1[drop-1] +" 카드를 버리셨습니다");


			Deck1[2] = Deck1[3];
			Deck1[3]="";
		}else {
			System.out.println(" "+Deck1[drop-1] +" 카드를 버리셨습니다");
			Deck1[3]="";
		}
	}
	// 오픈카드 최종덱에 추가
	public void plus(int x ,String [] final_deck,String open) {
		final_deck[x] =open;
	}
	// 최초덱을 최종덱에 추가
	public  void cc(String[] final_deck ,String[] deck) {
		for(int x =0; x<4;x++) {
			final_deck[x] = deck[x];
		}
	}
	// 턴 우선선위 결정
	public  double condeck(String x) {
		String a =x.substring(0,1);
		double a1=0;
		double b1=0;
		double c1=0;
		String b =x.substring(1,2);
		if(a.equals("A")) {
			a1 =14;
		}else if(a.equals("J")) {
			a1 =11;
		}else if(a.equals("Q")) {
			a1 =12;
		}
		else if(a.equals("K")) {
			a1 =13;
		}else if(a.equals("1")){
			a1 = 10;
		}else {
			a1 =Integer.parseInt(a);
		}

		if(b.equals("♣")){
			b1 =0.1;
		}else if (b.equals("♥")) {
			b1=0.2;
		}else if (b.equals("◆")) {
			b1=0.3;
		}else if (b.equals("♠")) {
			b1=0.4;
		}
		c1 =a1+b1;
		return c1;
	}


}
