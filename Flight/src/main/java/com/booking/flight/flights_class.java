package com.booking.flight;

public class flights_class {
        private String FNo;
        private String FName;
        private String FSource;
        private String FDepart;
        private String DepartTime;
        private String ArrTime;
        private String charge;


        public String getFNo() {
                return FNo;
        }

        public void setFNo(String FNo) {
                this.FNo = FNo;
        }

        public String getFName() {
                return FName;
        }

        public void setFName(String FName) {
                this.FName = FName;
        }

        public String getFSource() {
                return FSource;
        }

        public void setFSource(String FSource) {
                this.FSource = FSource;
        }

        public String getFDepart() {
                return FDepart;
        }

        public void setFDepart(String FDepart) {
                this.FDepart = FDepart;
        }

        public String getDepartTime() {
                return DepartTime;
        }

        public void setDepartTime(String departTime) {
                DepartTime = departTime;
        }

        public String getArrTime() {
                return ArrTime;
        }

        public void setArrTime(String arrTime) {
                ArrTime = arrTime;
        }

        public String getCharge() {
                return charge;
        }

        public void setCharge(String charge) {
                this.charge = charge;
        }
}
