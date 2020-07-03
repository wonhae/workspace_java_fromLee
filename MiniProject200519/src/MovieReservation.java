import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieReservation {
   
   public static void main(String[] args){   
      display();
   }
   
   // 1. Login
   // 2. 영화선택
   // 3. 영화관선택
   // 4. 결제방법선택
   // 5. 인원수 입력
   
   
   //
   public static void display(){
      
      ReservationVO rsvVO = new ReservationVO();
      
      Scanner sc = new Scanner(System.in);
               
      System.out.println("1. 로그인");
      System.out.println("2. 비밀번호찾기");
      System.out.println("3. 회원가입");
      System.out.println("0. 종료");
      
      int selectNum = sc.nextInt(); // 1 선택
      
      
      switch (selectNum) {
      case 1:
         login(rsvVO); //로그인 메소드 실행
         reservation(rsvVO);//로그인메소드 실행
         //예약 끝! 하지만 DB Update는 실행 안됨
         
         ReservationDAO dao = new ReservationDAO();         
         dao.rsvInsert(rsvVO);

         break;

      default:
         break;
      }         
         
      
   }//디스플레이끝남. 
   
   //로그인메소드
   public static void login(ReservationVO rsvVO){ 
      Scanner sc = new Scanner(System.in);
      
      String id;
      String pw;
      
      while(true){
         System.out.println("아이디 : ");
         id = sc.nextLine();      
         
         System.out.println("비밀번호 : ");
         pw = sc.nextLine();
         
         if(id.equals("dong1728") && pw.equals("1234")){
            System.out.println("로그인 성공!");
            rsvVO.setCustomer_Id(id);
            break;
         }else{
            System.out.println("로그인 실패ㅜㅜ");
         }
         
      }
      
      
      
      // 그다음 단계 -> DB에서 실제로 로그인 정보가 일치하는지 확인 (Select문 이용) -> ex) Select * from Customer where Id = ? && Pw = ? -> 둘다 일치하면 1개의 정보가 나옴
      // 일치하지 않으면 다시 입력
      
      
   }
   
   public static void reservation(ReservationVO rsvVO){
      
      int selectNum2 = 0;
      
       do{   //?
         
         String selectMvName = "";
         
         ArrayList<String> mvList = new ArrayList<>();
         mvList.add("신세계"); //0
         mvList.add("기생충"); //1
         mvList.add("타짜"); //2
         //위의 리스트는 실제 Movie Table에서 Select 로 검색 후에 mvList에 추가 하여야 함  ex) Select mvName from Movie;
         
               
         //영화선택      
         System.out.println("1. 신세계");
         System.out.println("2. 기생충");
         System.out.println("3. 타짜");       
         
         Scanner sc2 = new Scanner(System.in);      
         int selectNum = sc2.nextInt();
                  
         selectMvName = mvList.get(selectNum - 1);
         
         rsvVO.setMv_No(String.valueOf(selectNum));// 영화 이름이 아니라 영화 Id 가 필요함 Select문 이용 -> ex) Select Id from Movie where Name = ?
         
         System.out.println(selectMvName + " 선택 완료!");
         
         ArrayList<String> thList = new ArrayList<>();
         thList.add("강남CGV");
         thList.add("강변CGV");
         thList.add("안양CGV");
         
         //영화관선택      
         System.out.println("1. 강남CGV");
         System.out.println("2. 강변CGV");
         System.out.println("3. 안양CGV");
         System.out.println("4. 이전으로");
         
         selectNum = sc2.nextInt();
         if(selectNum <= thList.size() - 1){
            selectMvName = thList.get(selectNum - 1);
            rsvVO.setTh_No(String.valueOf(selectNum));// 영화관 이름이 아니라 영화관 Id 가 필요함 Select문 이용 -> ex) Select Id from Theater where Name = ?            
            System.out.println(selectMvName + " 선택 완료!");
            
         }else{
            selectNum2 = selectNum;
         }
         
      }while(selectNum2 == 4);
      
      
      
      
      
      
      
        }
   
}