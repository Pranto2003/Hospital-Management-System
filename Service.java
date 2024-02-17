package Entities;

	public class Service {
        private String ServiceName;
        private String ServiceDate;
        private String PatientID;
        private String PatientName;
        private double ServiceCharges;

        public Service(String PatientID, String PatientName,String ServiceName, String ServiceDate,  double ServiceCharges) {
            setServiceName(ServiceName);
            setServiceDate(ServiceDate);
            setPatientID(PatientID);
            setPatientName(PatientName);
            setServiceCharges(ServiceCharges);
        }

        // Setter methods
        public void setServiceName(String ServiceName) {
            this.ServiceName = ServiceName;
        }

        public void setServiceDate(String ServiceDate) {
            this.ServiceDate = ServiceDate;
        }

        public void setPatientID(String PatientID) {
            this.PatientID = PatientID;
        }

        public void setPatientName(String PatientName) {
            this.PatientName = PatientName;
        }

        public void setServiceCharges(double ServiceCharges) {
            this.ServiceCharges = ServiceCharges;
        }

        // Getter methods
        public String getServiceName() {
            return ServiceName;
        }

        public String getServiceDate() {
            return ServiceDate;
        }

        public String getPatientID() {
            return PatientID;
        }

        public String getPatientName() {
            return PatientName;
        }

        public double getServiceCharges() {
            return ServiceCharges;
        }

        // ShowInfo method
        public void ShowInfo() {
            System.out.println("Patient ID: " + PatientID);
            System.out.println("Patient Name: " + PatientName);
            System.out.println("Service Name: " + ServiceName);
            System.out.println("Service Date: " + ServiceDate);
            System.out.println("Service Charges: " + ServiceCharges);
            System.out.println("===============================================");
        }


    }

	
	
