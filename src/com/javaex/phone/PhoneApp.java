package com.javaex.phone;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		List<PersonVo> personList;
		PhoneDao pDao = new PhoneDao();
		
		System.out.println("****************************************");
		System.out.println("*          전화번호 관리 프로그램            *");
		System.out.println("****************************************");
		
		
		boolean repeat = true;	
		while(repeat) {
			System.out.println("\n1.리스트\t2.등록\t3.수정\t4.삭제\t5.검색\t6.종료");
			System.out.println("------------------------------------");
			System.out.print(">메뉴번호: ");
			String menuNo = sc.nextLine();
			
			switch(menuNo) {
				case "1" :
					personList = pDao.personSelect();
					for(PersonVo vo : personList) 
						vo.showInfo();
					break;
					
				case "2" : 
					System.out.println("<2.등록>");
					System.out.print(">이름: ");
					String name=sc.nextLine();
					System.out.print(">휴대전화: ");
					String phone=sc.nextLine();
					System.out.print(">회사전화: ");
					String company=sc.nextLine();
					
					PersonVo insertVo = new PersonVo(name, phone, company);
					pDao.personInsert(insertVo);
					break;
					
				case "3" : 
					System.out.println("<3.수정>");
					System.out.print(">번호: ");
					int personId=sc.nextInt();
					sc.nextLine();
					System.out.print(">이름: ");
					name=sc.nextLine();
					System.out.print(">휴대전화: ");
					phone=sc.nextLine();
					System.out.print(">회사전화: ");
					company=sc.nextLine();
					
					PersonVo updateVo = new PersonVo(personId, name, phone, company);
					pDao.personUpdate(updateVo);
					break;
					
				case "4" : 
					System.out.println("<4.삭제>");
					System.out.print(">번호 : ");
					int delNo = sc.nextInt();
					sc.nextLine();
					
					pDao.personDelete(delNo);
					break;
				
				case "5" : 
					System.out.println("<5.검색>");
					System.out.print(">검색어 : ");
					String key = sc.nextLine();
					
					personList = pDao.personSearch(key);
					for(PersonVo vo : personList) 
						vo.showInfo();
					break;	
					
				case "6" : 
					repeat = false;
					break;
					
				default : System.out.println("[다시 입력해 주세요.]");
				
			}
		}

		System.out.println("\n****************************************");
		System.out.println("*               감사합니다                *");
		System.out.println("****************************************");

		
		
		sc.close();
		
	}
}
