package model;

import java.sql.Timestamp;

public class Meeting {
	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public Integer getMeetingid() {
		return meetingid;
	}

	public void setMeetingid(Integer meetingid) {
		this.meetingid = meetingid;
	}

	public String getMeetingname() {
		return meetingname;
	}

	public void setMeetingname(String meetingname) {
		this.meetingname = meetingname;
	}

	public Integer getRoomid() {
		return roomid;
	}

	public void setRoomid(Integer roomid) {
		this.roomid = roomid;
	}

	public Integer getReservationistid() {
		return reservationistid;
	}

	public void setReservationistid(Integer reservationistid) {
		this.reservationistid = reservationistid;
	}

	public Integer getNumberofparticipants() {
		return numberofparticipants;
	}

	public void setNumberofparticipants(Integer numberofparticipants) {
		this.numberofparticipants = numberofparticipants;
	}

	public Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public Timestamp getReservationtime() {
		return reservationtime;
	}

	public void setReservationtime(Timestamp reservationtime) {
		this.reservationtime = reservationtime;
	}

	public Timestamp getCanceledtime() {
		return canceledtime;
	}

	public void setCanceledtime(Timestamp canceledtime) {
		this.canceledtime = canceledtime;
	}

	public Timestamp getDescription() {
		return description;
	}

	public void setDescription(Timestamp description) {
		this.description = description;
	}

	public Timestamp getStatus() {
		return status;
	}

	public void setStatus(Timestamp status) {
		this.status = status;
	}

	public Meeting() {
	}


	private String roomname;
	private Integer meetingid;
	private String meetingname;
	private Integer roomid;
	private Integer reservationistid;
	private Integer numberofparticipants;
	private Timestamp starttime;
	private Timestamp endtime;
	private Timestamp reservationtime;
	private Timestamp canceledtime;
	private Timestamp description;
	private Timestamp status;

	@Override
	public String toString() {
		return "Meeting{" +
				"roomname='" + roomname + '\'' +
				", meetingid=" + meetingid +
				", meetingname='" + meetingname + '\'' +
				", roomid=" + roomid +
				", reservationistid=" + reservationistid +
				", numberofparticipants=" + numberofparticipants +
				", starttime=" + starttime +
				", endtime=" + endtime +
				", reservationtime=" + reservationtime +
				", canceledtime=" + canceledtime +
				", description=" + description +
				", status=" + status +
				'}';
	}

	public Meeting(String meetingname, String roomname, Timestamp starttime, Timestamp endtime, Timestamp reservationtime) {
		this.roomname = roomname;
		this.meetingname = meetingname;
		this.starttime = starttime;
		this.endtime = endtime;
		this.reservationtime = reservationtime;
	}

	public Meeting(String roomname, Integer meetingid, String meetingname, Integer roomid, Integer reservationistid, Integer numberofparticipants, Timestamp starttime, Timestamp endtime, Timestamp reservationtime, Timestamp canceledtime, Timestamp description, Timestamp status) {
		this.roomname = roomname;
		this.meetingid = meetingid;
		this.meetingname = meetingname;
		this.roomid = roomid;
		this.reservationistid = reservationistid;
		this.numberofparticipants = numberofparticipants;
		this.starttime = starttime;
		this.endtime = endtime;
		this.reservationtime = reservationtime;
		this.canceledtime = canceledtime;
		this.description = description;
		this.status = status;

		//meetingname,roomname,starttime,endtime,reservationtime
	}
}
