package site.metacoding.ex23;

public class StringCollectionEx01 {
    public static void main(String[] args) {
        // StringBuffer는 자원을 동기화 한다.
        StringBuffer sb = new StringBuffer();
        
        // 오브젝트라서 모든 타입 사용 가능
        // 메모리 공간 관리 효율성 좋음
        // 가독성이 좋음
        // 긴 문자열을 저장할 때 사용한다.
        sb.append("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst?");
        sb.append(
                "serviceKey=wJmmW29e3AEUjwLioQR22CpmqS645ep4S8TSlqtSbEsxvnkZFoNe7YG1weEWQHYZ229eNLidnI2Yt5EZ3Stv7g%3%3D&");
        sb.append("numOfRows=10&");
        sb.append("pageNo=1&");
        sb.append("dataType=JSON&");
        sb.append("base_date=20220126&");
        sb.append("base_time=1700&");
        sb.append("nx=97&");
        sb.append("ny=75");

        System.out.println(sb.toString());
    }
}
