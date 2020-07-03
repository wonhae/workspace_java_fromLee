package V_RsvPackage;

import java.io.Serializable;

public class V_RsvDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String customerId;
	private String customerName;
	private String movieId;
	private String movieTitle;
	private String theaterId;
	private String theaterName;
	private String rsvId;
	private String rsvDay;
	private String rsvTime;
	private int rsvNum;
	private String rsvPaymentMethod;
	private int rsvTotal;
	
	public V_RsvDTO() {
		// TODO Auto-generated constructor stub
	}

	
	
	public V_RsvDTO(String customerId, String customerName, String movieId, String movieTitle, String theaterId,
			String theaterName, String rsvId, String rsvDay, String rsvTime, int rsvNum, String rsvPaymentMethod,
			int rsvTotal) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.theaterId = theaterId;
		this.theaterName = theaterName;
		this.rsvId = rsvId;
		this.rsvDay = rsvDay;
		this.rsvTime = rsvTime;
		this.rsvNum = rsvNum;
		this.rsvPaymentMethod = rsvPaymentMethod;
		this.rsvTotal = rsvTotal;
	}



	

	public String getCustomerId() {
		return customerId;
	}



	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getMovieId() {
		return movieId;
	}



	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}



	public String getMovieTitle() {
		return movieTitle;
	}



	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}



	public String getTheaterId() {
		return theaterId;
	}



	public void setTheaterId(String theaterId) {
		this.theaterId = theaterId;
	}



	public String getTheaterName() {
		return theaterName;
	}



	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}



	public String getRsvId() {
		return rsvId;
	}



	public void setRsvId(String rsvId) {
		this.rsvId = rsvId;
	}



	public String getRsvDay() {
		return rsvDay;
	}



	public void setRsvDay(String rsvDay) {
		this.rsvDay = rsvDay;
	}



	public String getRsvTime() {
		return rsvTime;
	}



	public void setRsvTime(String rsvTime) {
		this.rsvTime = rsvTime;
	}



	public int getRsvNum() {
		return rsvNum;
	}



	public void setRsvNum(int rsvNum) {
		this.rsvNum = rsvNum;
	}



	public String getRsvPaymentMethod() {
		return rsvPaymentMethod;
	}



	public void setRsvPaymentMethod(String rsvPaymentMethod) {
		this.rsvPaymentMethod = rsvPaymentMethod;
	}



	public int getRsvTotal() {
		return rsvTotal;
	}



	public void setRsvTotal(int rsvTotal) {
		this.rsvTotal = rsvTotal;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rsvId == null) ? 0 : rsvId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		V_RsvDTO other = (V_RsvDTO) obj;
		if (rsvId == null) {
			if (other.rsvId != null)
				return false;
		} else if (!rsvId.equals(other.rsvId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "예매내역 조회 [고객성함=" + customerName + ", 영화제목=" + movieTitle + ", 영화관="
				+ theaterName + ", 예매번호=" + rsvId + ", 예매날짜=" + rsvDay + ", 상영시간대"
						+ "+=" + rsvTime + ", 예매 인원="
				+ rsvNum + "]";
	}
	
	
}
