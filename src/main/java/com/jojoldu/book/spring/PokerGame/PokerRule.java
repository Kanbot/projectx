package com.jojoldu.book.spring.PokerGame;

import java.util.Collections;

public class PokerRule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] Deck = new String[7]; // 딜러 덱
		String[] Deck1 = new String[7]; // 플레이어 덱
		String[] Decka = new String[7]; // 딜러 덱 문자
		String[] Deckb = new String[7]; // 딜러 덱 숫자
		String[] Deckc = new String[7]; // 플레이어 덱 문자
		String[] Deckd = new String[7]; // 플레이어 덱 숫자

		double[] Deck_int = new double[7]; // 숫자를 문자로 변환한 딜러 덱
		double[] Deck_int1 = new double[7]; // 숫자를 문자로 변환한 플레이어 덱

		double num = 0; // 딜러 덱 최대값
		double num1 = 0; // 플레이어 덱 최대값

		Rule rr = new Rule();
		Deck dk = new Deck();

		try {
			dk.Newly(dk.Card); // 랜덤 카드 생성
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 랜덤 카드 문양 추가
		dk.Convert("♣", 0, 13);
		dk.Convert("♠", 13, 26);
		dk.Convert("♥", 26, 39);
		dk.Convert("◆", 39, 52);

		dk.dis(Deck); // 딜러 덱 중복 제거
		dk.dis(Deck1); // 플레이어 덱 중복 제거

		dk.caedc(Deck, Decka, Deckb); // 딜러 덱 문자 와 숫자 분리
		dk.caedc(Deck1, Deckc, Deckd); // 플레이어 덱 문자 와 숫자 분리
		dk.change(Decka); // 딜러덱 문자를 숫자로 변환
		dk.change(Deckc); // 플레이어덱 문자르 숫자로 변환
		dk.convert(Decka, Deckb, Deck_int); // 딜러 덱 숫자를 문자로 변환
		dk.convert(Deckc, Deckd, Deck_int1); // 플레이어 덱 숫자를 문자로 변환
		double[] jokbo = rr.rule(Deck_int); // 딜러 덱 숫자 족보
		double[] jokbo1 = rr.rule(Deck_int1); // 플레이어 덱 숫자 족보
		num = dk.sort(Deck_int); // 딜러 덱 최대값
		num1 = dk.sort(Deck_int1); // 플레이어 덱 최대값
		double[] st = rr.streight(Deck_int); // 딜러 덱 스트레이트 판단
		double[] st1 = rr.streight(Deck_int1); // 플레이어 덱 스트레이트 판단
		int f = rr.flush(Deck_int); // 딜러 덱 플러쉬 판단
		int f1 = rr.flush(Deck_int1); // 플레이어 덱 플러쉬 판단

		rr.qual(jokbo, jokbo1, st, st1, f, f1); // 족보값 결정

		String qq = dk.rechan(jokbo[1]); // 딜러 덱 평가값 변경
		String qq1 = dk.rechan(jokbo1[1]); // 플레이어 덱 평가값 변경
		String set=dk.rechan(st[3]); // 딜러 스트레이트 평가값 변경
		String set1= dk.rechan(st[3]); // 플레이어 스트레이트 평가값 변경
		String nn = dk.rechan(num); // 딜러 노페어,백스트,마운틴 평가값
		String nn1 = dk.rechan(num1); // 플레이어 노페어,백스트,마운틴 평가값

		rr.print(jokbo[0], qq, nn ,set); // 딜러 결과 출력
		dk.Deckdis(Deck); // 딜러 덱 출력
		rr.print(jokbo1[0], qq1, nn1,set1); // 플레이어 결과 출력
		dk.Deckdis(Deck1); // 플레이어 덱 출력
		rr.jude(jokbo, jokbo1, num, num1); // 승패 판단 및 승패 출력

	}
}

class Rule {

	// 숫자 족보
	public double[] rule(double[] Deck) {
		double count = 0;
		double unit = 0;

		for (int x = 0; x < Deck.length; x++) {
			for (int y = x + 1; y < Deck.length; y++) {
				if ((int) Deck[x] == (int) (Deck[y])) {
					if ((int) unit < (int) (Deck[x])) {
						unit = Deck[x];
					}

					count++;

				}

			}

		}

		return new double[] { count, unit };
	}

	public void qual(double[] jokbo, double[] jokbo1, double[] st, double[] st1, int x, int y) {
		// TODO Auto-generated method stub
		if (st[2] >= 5) {
			jokbo[0] = 3.1;
		}
		if (st1[2] >= 5) {
			jokbo1[0] = 3.1;
		}
		if (st[0] == 5) {
			jokbo[0] = 3.2;
		}
		if (st1[0] == 5) {
			jokbo1[0] = 3.2;
		}
		if (st[1] == 5) {
			jokbo[0] = 3.3;
		}
		if (st1[1] == 5) {
			jokbo1[0] = 3.3;
		}
		if (x >= 5) {
			jokbo[0] = 3.4;
		}
		if (y >= 5) {
			jokbo1[0] = 3.4;
		}
		if (st[2] == 4 && x == 4) {
			jokbo[0] = 7;
		}
		if (st1[2] == 4 && y == 4) {
			jokbo1[0] = 7;
		}
		if (st[0] == 5 && x == 4) {
			jokbo[0] = 8;
		}
		if (st1[0] == 5 && y == 4) {
			jokbo1[0] = 8;
		}
		if (st[1] == 5 && x == 4) {
			jokbo[0] = 9;
		}
		if (st1[1] == 5 && y == 4) {
			jokbo1[0] = 9;
		}
	}

	// 족보 출력
	public void print(double count, String num, String nn,String st) {

		if (num.substring(0, 1).equals("1")) {
			num = "10" + num.substring(1, 2);
		}
		if (nn.substring(0, 1).equals("1")) {
			nn = "10" + nn.substring(1, 2);
		}
		if (st.substring(0, 1).equals("1")) {
			st = "10" + st.substring(1, 2);
		}
		if (count == 0) {
			System.out.println(nn + "노페어 입니다");
		} else if (count == 1) {
			System.out.println(num + "원페어 입니다");
		} else if (count == 2) {
			System.out.println(num + "투페어 입니다");
		} else if (count == 3) {
			System.out.println(num + "트리플 입니다.");
		} else if (count == 3.1) {
			System.out.println(st + "스트레이트 입니다.");
		} else if (count == 3.2) {
			System.out.println(nn + "백스트레이트 입니다.");
		} else if (count == 3.3) {
			System.out.println(nn + "마운틴 입니다.");
		} else if (count == 3.4) {
			System.out.println(num + "플러쉬 입니다.");
		} else if (count == 4) {
			System.out.println(num + "풀 하우스 입니다.");
		} else if (count == 6) {
			System.out.println(num + "포카드 입니다.");
		} else if (count == 7) {
			System.out.println(num + "스트레이트 플러쉬 입니다.");
		} else if (count == 8) {
			System.out.println(num + "백스트레이트 플러쉬 입니다.");
		} else if (count == 9) {
			System.out.println(num + "로얄 스트레이트 플러쉬 입니다.");
		} else {
			System.out.println("오류");
		}

		// 풀 하우스 , 포카드 ,트리플 ,투페어 ,원페어
	}

	// 승패 판단
	public int jude(double[] x, double[] y, double num, double num1) {
		int s=0;
		s=this.judeinsert(x[0], y[0], 0, num, num1);
		s=this.judeinsert(x[0], y[0], 1, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 2, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 3, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 3.1, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 3.2, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 3.3, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 3.4, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 4, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 6, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 7, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 8, x[1], y[1]);
		s=this.judeinsert(x[0], y[0], 9, x[1], y[1]);
		if (x[0] > y[0]) {
			System.out.println("딜러 의 승리");
			s= 0;
		} else if (x[0] < y[0]) {
			System.out.println("플레이어 의 승리");
			s=1;
		}
		return s;
	}

	// 결과 if 메소드
	public int judeinsert(double x, double y, double a, double num, double num1) {
		int q=0;
		if (x == a && y == a) {
			if (num > num1) {
				System.out.println("딜러 의 승리");
				q=0;
			} else {
				System.out.println("플레이어 의 승리");
				q=1;
			}
		}
		return q;
	}

	// 스트레이트 판단
	public double[] streight(double[] Deck) {
		double count = 0; // 빽스트레이트
		double mount = 0; // 마운틴
		double sount = 0; // 스트레이트
		double set = 0; // 스트레이트 평가값
		double[] st = { 2, 3, 4, 5, 14 };
		double[] mt = { 10, 11, 12, 13, 14 };
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < Deck.length; y++) {
				if (st[x] == (int) (Deck[y])) {
					count++;
					break;
				}
			}
		}
		for (int x = 0; x < 5; x++) {
			for (int y = 0; y < Deck.length; y++) {
				if (mt[x] == (int) Deck[y]) {
					mount++;
					break;
				}
			}
		}

		for (int i = 0; i < 6; i++) {

			if (((int) Deck[i + 1] - (int) Deck[i]) == 1) {
				sount++;

			}
			if ((int) Deck[i + 1] - (int) Deck[i] != 1) {
				sount--;
			}
		}
		if ((int) Deck[3] - (int) Deck[2] == 1 && (int) Deck[4] - (int) Deck[3] == 1 && sount == 2
				&& Deck[5] == Deck[6]) {
			sount = 5;
		}
		if ((int) Deck[3] - (int) Deck[2] == 1 && (int) Deck[4] - (int) Deck[3] == 1 && sount == 2
				&& Deck[0] == Deck[1]) {
			sount = 5;
		}
		if ((int) Deck[3] - (int) Deck[2] == 1 && (int) Deck[4] - (int) Deck[3] == 1 && sount == 2
				&& Deck[0] == Deck[6]) {
			sount = 5;
		}
		if ((int) Deck[3] - (int) Deck[2] == 1 && (int) Deck[4] - (int) Deck[3] == 1 && sount == 4
				&& (int) Deck[6] - (int) Deck[5] == 1) {
			sount = 5;
		}
		if ((int) Deck[3] - (int) Deck[2] == 1 && (int) Deck[4] - (int) Deck[3] == 1 && sount == 4
				&& (int) Deck[5] - (int) Deck[4] == 1) {
			sount = 5;
		}
		if ((int) Deck[3] - (int) Deck[2] == 1 && (int) Deck[4] - (int) Deck[3] == 1 && sount == 4
				&& (int) Deck[2] - (int) Deck[1] == 1) {
			sount = 5;
		}
		if ((int) Deck[3] - (int) Deck[2] == 1 && (int) Deck[4] - (int) Deck[3] == 1 && sount == 4
				&& (int) Deck[1] - (int) Deck[0] == 1) {
			sount = 5;
		}
		if((int)Deck[5] -(int)Deck[4] ==1) {
			set =Deck[5];
			if((int)Deck[5] ==(int)Deck[6] && Deck[5] <Deck[6] ) {
				set =Deck[6];
			}
		}
		else if((int)Deck[5] - (int)Deck[4] ==1 && (int)Deck[6] -(int)Deck[5] ==1) {
			set =Deck[6];
		}else {
			set =Deck[4];
			if((int)Deck[4] ==(int)Deck[5] && Deck[4] <Deck[5] ) {
				set =Deck[5];
			}
			if((int)Deck[5] ==(int)Deck[6] && Deck[5] <Deck[6] ) {
				set =Deck[6];
			}
		}
		return new double[] { count, mount, sount ,set};
	}

	// 플러쉬 판단
	public int flush(double[] Deck) {
		Deck dk = new Deck();
		double[] x = new double[7];
		int c = 0;
		for (int i = 0; i < Deck.length; i++) {
			x[i] = Deck[i] - (int) Deck[i];
			x[i] = Double.parseDouble(String.format("%.1f", x[i]));

		}
		dk.sort1(x);

		for (int i = 0; i < 6; i++) {
			if (x[i + 1] == x[i]) {
				c++;
			}
			if (x[i + 1] != x[i]) {
				c--;
			}

		}
		if (x[0] != x[6] && c == 2 && x[0] != x[1] && x[5] != x[6]) {
			c = 5;
		}
		if (x[2] == x[3] && x[3] == x[4] && c == 4) {
			c = 5;
		}
		if(x[4] == x[5]) {

		}
		return c;
	}
	// 승리
	public  double win(double [] Bat ,double player_money ) {
		if(Bat[1] == 3 && player_money !=0) {
			player_money += Bat[0];
			System.out.println((int)Bat[0]+"원을 따셨습니다");
			System.out.println("현재 소지금: "+(int)player_money);
		}else if (Bat[1] ==3 && player_money == 0) {


		}
		return player_money;
	}
	// 패배
	public  void lose(double [] Bat ,double player_money) {
		if(Bat[1] == 3) {
			player_money =1000000- player_money;
			System.out.println((int)player_money+"원을 잃"
					+ "으셨습니다");
		}

	}
}
