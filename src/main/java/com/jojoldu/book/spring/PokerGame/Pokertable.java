package com.jojoldu.book.spring.PokerGame;
import java.util.Scanner;


public class Pokertable {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		PokerRule pk = new PokerRule();
		Deck dk =new Deck();
		Util ut =new Util();
		Rule rr =new Rule();
		Betting bt =new Betting();
		Scanner sc =new Scanner(System.in);

		String[] Deck_final =new String[7];  //플레이어 최종덱
		String[] Deck_final1 =new String[7]; //딜러 최종덱
		String[] Deck =  new String [4];  // 딜러 최초덱
		String[] Deck1 = new String [4];  // 플레이어 최초덱
		String[] Decka = new String[7]; // 플레이어 최초 숫자열
		String[] Deckb = new String[7]; // 플레이어 최초 문자열
		String[] Deckc = new String[7]; // 딜러 최초 숫자열
		String[] Deckd = new String[7]; // 딜러 쵳 문자열

		String open1=""; // 플레이어 1번째 오픈 카드
		String open2=""; // 플레이어 2번째 오픈 카드
		String open3=""; // 플레이어 3번째 오픈 카드
		String open4=""; // 플레이어 4번째 오픈 카드
		String hidden=""; // 플레이어 히든 카드
		String open2_d=""; // 딜러 2번째 오픈 카드
		String open3_d=""; // 딜러 3번쨰 오픈 카드ㄴ
		String open4_d=""; // 딜러 4번쨰 오픈 카드
		String hidden_d=""; // 딜러 히든 카드

		double[] Deck_int = new double[7]; //숫자를 문자로 변환한 딜러 덱
		double[] Deck_int1 = new double[7]; // 숫자를 문자로 변환한 플레이어 덱
		double[] Bat = {100,0,0,1000000}; // 배팅 금액, 배팅 토큰, 선후 차례,소지금

		double player; //플레이어 선 토큰
		double dealer; //딜러 선 토큰
		double player_money =1000000; // 플레이어 소지금
		double num = 0; // 딜러 노페어  최대값
		double num1 = 0; // 플레이어 노페어 최대값

		int so =0; // 공백용 허수
		int vic =0; // 승리 변수 0-딜러 승리 1 -플레이어 승리

		while(player_money >=0) { // 게임 끝 경계
			while(player_money >-1) { // 게임 반복 경계
				Bat[0] =100; // 변수 초기화
				Bat[1] =0;
				Bat[2] =0;
				//카드 덱 초기화
				try {
					dk.Newly(dk.Card);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//문양 배분
				dk.Convert("♣", 0, 13);
				dk.Convert("♠", 13, 26);
				dk.Convert("♥", 26, 39);
				dk.Convert("◆", 39, 52);
				//딜러 덱 중복 제거
				try{
					dk.dis(Deck);
				}catch(Exception e) {

				}
				// 플레이어 덱 중복 제거
				try {
					dk.dis(Deck1);
				}catch(Exception e) {

				}

				//////////////////게임 시작 문구 //////////////////////////////
				System.out.println("포커 게임을 시작합니다.");
				System.out.println("현재 소지금은:" + (int)player_money+ "원" );
				System.out.println("--- 카드 셔플 ---");
				System.out.println(" 딜러    에게 카드 4장이 분배 되었습니다.");
				System.out.println(" 플레이어 에게 카드 4장이 분배 되었습니다.");
				System.out.println("--- 플레이어 덱 ---");

				for(int x =0; x <4; x++) {
					System.out.print(" "+"["+(x+1)+"] "+Deck1[x]+" ");
				}
				ut.space();
				System.out.println("버리실 카드 한장을 선택 해주세요.(1~4)");
				int drop =sc.nextInt();
				dk.drop(drop,Deck1); // 버릴 카드 지정후 삭제


				System.out.println("--- 남은 카드 ---");
				for(int x=0; x<3;x ++) {
					System.out.print(" "+"["+(x+1)+"]"+" "+Deck1[x]);
				}
				ut.space();
				System.out.println("공개할 카드를 한장 고르세요");

				int open =sc.nextInt();
				open1 =dk.opens(open,Deck1,open1); // 공개할 오픈 카드 1개 선정

				ut.clean();
				dk.cc(Deck_final,Deck); // 딜러 최초덱을 최종덱에 삽입
				dk.cc(Deck_final1,Deck1);// 플레이어 최초덱을 최종덱에 삽입
				System.out.println("----------------------------------");
				System.out.println("딜러    오픈 덱 "+Deck[0]);
				System.out.print("플레이어 오픈 덱 "+open1 + "  플레이어 보유 덱"	);
				for(int x =0 ; x<3; x++) {
					if(Deck1[x] != open1){
						System.out.print(" "+Deck1[x]);
					}
				}
				ut.space();
				System.out.println("----------------------------------");
				player =dk.condeck(open1);
				dealer =dk.condeck(Deck[0]);
				//if(player < dealer) {
				///두번째 오픈 카드 페이즈 //////////////////////////////////////////////////
				ut.piase(2,so); // 카드 페이즈 안내 문구
				System.out.print("딜러 카드");
				open2_d=dk.newcard(Deck_final, Deck_final1);
				System.out.println("     "+open2_d);
				dk.plus(3,Deck_final,open2_d);
				System.out.print("플레이어 카드");

				open2=dk.newcard(Deck_final, Deck_final1);
				System.out.println("  "+open2);
				dk.plus(3,Deck_final1,open2);
				System.out.println("------------------------------------------");

				System.out.println("딜러    오픈 덱 "+Deck[0]+" "+Deck_final[3]);
				System.out.print("플레이어 오픈 덱 "+open1 +" "+open2+ "  플레이어 보유 덱"	);
				for(int x =0 ; x<4; x++) {
					if(Deck1[x] != open1){
						System.out.print(" "+Deck1[x]);
					}
				}

				ut.space();
				System.out.println("배팅 페이즈를 시작하겠습니까?(아무나 키나 입력)");
				so=sc.nextInt();
				ut.note();
				sc.nextLine();

				///// 배팅 페이즈 ///////////////////////////////////////////////////////////

				while(Bat[1] !=2 && Bat[1] !=3) {



					System.out.println("-----------------------------------------");
					System.out.println("딜러 배팅 턴 입니다.");
					Bat=bt.ifd(Bat[0],Bat[1],Bat[2],player_money); // 딜러 배팅
					player_money=rr.win(Bat,player_money);
					if(Bat[1] == 3) {
						break;
					}
					if(Bat[1] == 2) {
						break;
					}
					System.out.println("-----------------------------------------");
					ut.space();

					System.out.println("-----------------------------------------");
					System.out.println("플레이어 배팅 턴 입니다.(입력)");


					String bet =sc.nextLine(); // 플레이어 배팅
					if(bet.equals("체크") && Bat[2] != 0) {
						System.out.println("체크는 첫번째 순서 플레이어만 가능 합니다");

						System.out.println("다시 입력해주세요.");

						bet =sc.nextLine();
					}
					if(bet.equals("뻥") && Bat[2] != 0) {
						System.out.println("체크는 첫번째 순서 플레이어만 가능 합니다");
						System.out.println("다시 입력해주세요.");
						bet =sc.nextLine();

					}


					Bat=bt.ifb(bet,Bat[0],player_money,Bat[1],Bat[2],Bat); //플레이어 배팅
					player_money= Bat[3];
					rr.lose(Bat,player_money);
					System.out.println("현재 소지금: "+(int)player_money);
					System.out.println("-----------------------------------------");
				}
				System.out.println("두번째 오픈 페이즈 끝");
				if(Bat[1] ==3) {
					break;
				}

				Bat[1] =0;


				//3 번 째 오픈카드///////////////////////////////////////////////////////////

				ut.piase(3,so);
				System.out.print("딜러 카드");
				open3_d=dk.newcard(Deck_final, Deck_final1);
				System.out.println("     "+open3_d);
				dk.plus(4,Deck_final,open3_d);
				System.out.print("플레이어 카드");

				open3=dk.newcard(Deck_final, Deck_final1);
				System.out.println("  "+open3);
				dk.plus(4,Deck_final1,open3);
				System.out.println("------------------------------------------");

				System.out.println("딜러    오픈 덱 "+Deck[0]+" "+Deck_final[3] +" "+Deck_final[4]);
				System.out.print("플레이어 오픈 덱 "+open1 +" "+open2+" "+ open3+ "  플레이어 보유 덱"	);
				for(int x =0 ; x<4; x++) {
					if(Deck1[x] != open1){
						System.out.print(" "+Deck1[x]);
					}
				}

				ut.space();
				if(Bat[2] == 4) {

				}else {
					System.out.println("배팅 페이즈를 시작하겠습니까?(아무나 키나 입력)");
					so=sc.nextInt();
					ut.note1(Bat[0]);
					sc.nextLine();

					///// 배팅 페이즈 ///////////////////////////////////////////////////////////

					while(Bat[1] !=2 ||	 Bat[1] !=3) {

						System.out.println("-----------------------------------------");
						System.out.println("딜러 배팅 턴 입니다.");
						Bat=bt.ifd(Bat[0],Bat[1],Bat[2],player_money); // 딜러 배팅
						player_money=rr.win(Bat,player_money);
						if(Bat[1] == 3) {
							break;
						}

						System.out.println("-----------------------------------------");
						ut.space();

						System.out.println("-----------------------------------------");
						System.out.println("플레이어 배팅 턴 입니다.(입력)");

						String bet =sc.nextLine(); // 플레이어 배팅
						if(bet.equals("체크") && Bat[2] != 0) {
							System.out.println("체크는 첫번째 순서 플레이어만 가능 합니다");
							System.out.println("다시 입력해주세요.");
							bet =sc.nextLine();
						}
						if(bet.equals("뻥") && Bat[2] != 0) {
							System.out.println("체크는 첫번째 순서 플레이어만 가능 합니다");
							System.out.println("다시 입력해주세요.");
							bet =sc.nextLine();
						}


						Bat=bt.ifb(bet,Bat[0],player_money,Bat[1],Bat[2],Bat);
						player_money= Bat[3];
						rr.lose(Bat,player_money);
						System.out.println("현재 소지금: "+(int)player_money);
						System.out.println("-----------------------------------------");
					}
				}
				System.out.println("세번째 오픈 페이즈 끝");
				if(Bat[1] ==3) {
					break;
				}
				Bat[1] =0;


				// 4 번째 오픈 페이즈 ////////////////////////////////////////////////////////////////////

				ut.piase(4,so);
				System.out.print("딜러 카드");
				open4_d=dk.newcard(Deck_final, Deck_final1);
				System.out.println("     "+open4_d);
				dk.plus(5,Deck_final,open4_d);
				System.out.print("플레이어 카드");

				open4=dk.newcard(Deck_final, Deck_final1);
				System.out.println("  "+open4);
				dk.plus(5,Deck_final1,open4);
				System.out.println("------------------------------------------");

				System.out.println("딜러    오픈 덱 "+Deck[0]+" "+Deck_final[3] +" "+Deck_final[4]+" "+Deck_final[5]);
				System.out.print("플레이어 오픈 덱 "+open1 +" "+open2+" "+ open3+ " "+open4+"  플레이어 보유 덱"	);
				for(int x =0 ; x<4; x++) {
					if(Deck1[x] != open1){
						System.out.print(" "+Deck1[x]);
					}
				}

				ut.space();
				if(Bat[2] == 4) {

				}else {
					System.out.println("배팅 페이즈를 시작하겠습니까?(아무나 키나 입력)");
					so=sc.nextInt();
					ut.note1(Bat[0]);
					sc.nextLine();

					///// 배팅 페이즈 ///////////////////////////////////////////////////////////

					while(Bat[1] !=2 && Bat[1] !=3) {

						System.out.println("-----------------------------------------");
						System.out.println("딜러 배팅 턴 입니다.");
						Bat=bt.ifd(Bat[0],Bat[1],Bat[2],player_money); // 딜러 배팅
						player_money=rr.win(Bat,player_money);
						if(Bat[1] == 3) {
							break;
						}
						if(Bat[1] == 2) {
							break;
						}

						System.out.println("-----------------------------------------");
						ut.space();

						System.out.println("-----------------------------------------");
						System.out.println("플레이어 배팅 턴 입니다.(입력)");

						String bet =sc.nextLine(); // 플레이어 배팅
						if(bet.equals("체크") && Bat[2] != 0) {
							System.out.println("체크는 첫번째 순서 플레이어만 가능 합니다");
							System.out.println("다시 입력해주세요.");
							bet =sc.nextLine();
						}
						if(bet.equals("뻥") && Bat[2] != 0) {
							System.out.println("체크는 첫번째 순서 플레이어만 가능 합니다");
							System.out.println("다시 입력해주세요.");
							bet =sc.nextLine();
						}


						Bat=bt.ifb(bet,Bat[0],player_money,Bat[1],Bat[2],Bat);
						player_money= Bat[3];
						rr.lose(Bat,player_money);
						System.out.println("현재 소지금: "+(int)player_money);
						System.out.println("-----------------------------------------");
					}
				}
				System.out.println("네번째 오픈 페이즈 끝");
				if(Bat[1] ==3) {
					break;
				}
				Bat[1] =0;


				// 히든 카드 페이즈 /////////////////////////////////////////////////////////////////
				System.out.println("히든카드  페이즈");
				System.out.println("새로운 카드를 뽑숩니다.(1 ~9) 입력");
				so =sc.nextInt();
				System.out.println("---히든 카드 배분---");
				System.out.print("딜러 카드");
				hidden_d=dk.newcard(Deck_final, Deck_final1);
				System.out.println("     "+hidden_d);
				dk.plus(6,Deck_final,hidden_d);
				System.out.print("플레이어 카드");

				hidden=dk.newcard(Deck_final, Deck_final1);
				System.out.println("  "+hidden);
				dk.plus(6,Deck_final1,hidden);
				System.out.println("------------------------------------------");

				System.out.println("딜러    오픈 덱 "+Deck[0]+" "+Deck_final[3] +" "+Deck_final[4]+" "+Deck_final[5]);
				System.out.print("플레이어 오픈 덱 "+open1 +" "+open2+" "+ open3+ " "+open4+"  플레이어 보유 덱"	);
				for(int x =0 ; x<4; x++) {

					if(Deck1[x] != open1){
						System.out.print(" "+Deck1[x]);
					}

				}
				System.out.print("  히든카드: "+hidden);
				ut.space();
				if(Bat[2] == 4) {

				}else {
					System.out.println("배팅 페이즈를 시작하겠습니까?(아무나 키나 입력)");
					so=sc.nextInt();
					ut.note1(Bat[0]);
					sc.nextLine();

					///// 배팅 페이즈 ///////////////////////////////////////////////////////////

					while(Bat[1] !=2 && Bat[1] !=3) {

						System.out.println("-----------------------------------------");
						System.out.println("딜러 배팅 턴 입니다.");
						Bat=bt.ifd(Bat[0],Bat[1],Bat[2],player_money); // 딜러 배팅
						player_money=rr.win(Bat,player_money);
						if(Bat[1] == 3) {
							break;
						}
						if(Bat[1] == 2) {
							break;
						}
						System.out.println("-----------------------------------------");
						ut.space();


						System.out.println("-----------------------------------------");
						System.out.println("플레이어 배팅 턴 입니다.(입력)");


						String bet =sc.nextLine(); // 플레이어 배팅
						if(bet.equals("체크") && Bat[2] != 0) {
							System.out.println("체크는 첫번째 순서 플레이어만 가능 합니다");
							System.out.println("다시 입력해주세요.");

							bet =sc.nextLine();
						}
						if(bet.equals("뻥") && Bat[2] != 0) {
							System.out.println("체크는 첫번째 순서 플레이어만 가능 합니다");
							System.out.println("다시 입력해주세요.");
							bet =sc.nextLine();
						}


						Bat=bt.ifb(bet,Bat[0],player_money,Bat[1],Bat[2],Bat);
						player_money= Bat[3];
						rr.lose(Bat,player_money);
						System.out.println("현재 소지금: "+(int)player_money);
						System.out.println("-----------------------------------------");
					}
				}
				System.out.println("히든 카드 페이즈 끝");
				if(Bat[1] ==3) {
					break;
				}
				Bat[1] =0;

				ut.clean();

				dk.caedc(Deck_final, Decka, Deckb); // 딜러 덱 문자 와 숫자 분리
				dk.caedc(Deck_final1, Deckc, Deckd); // 플레이어 덱 문자 와 숫자 분리
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
				dk.Deckdis(Deck_final); // 딜러 덱 출력
				rr.print(jokbo1[0], qq1, nn1,set1); // 플레이어 결과 출력
				dk.Deckdis(Deck_final1); // 플레이어 덱 출력
				vic=rr.jude(jokbo, jokbo1, num, num1); // 승패 판단 및 승패 출력
				if(vic ==0) {
					player_money -= Bat[0];
				}else if(vic ==1) {
					player_money += Bat[0];
				}
				System.out.println("플레이어 소지금: " + (int)player_money);
				System.out.println("다음 판을 하시겠습니까?(예/아니오)");
				String vx =sc.nextLine();
				if(vx.equals("예")) {
					System.out.println("다음판을 시작합니다.");
					ut.space();
				}else if(vx.equals("아니오")) {
					System.out.println("게임을 종료 합니다.");
					break;
				}
				ut.clean();

			}
			System.out.println("게임 끝");
			System.out.println("다음 판을 하시겠습니까?(예/아니오)");
			String vx =sc.nextLine();
			if(vx.equals("예")) {
				System.out.println("다음판을 시작합니다.");
				ut.space();
			}else if(vx.equals("아니오")) {
				System.out.println("게임을 종료 합니다.");
				break;
			}
		}



		System.out.println("현재 한강 온도는"+ "입니다.");

	}







}

