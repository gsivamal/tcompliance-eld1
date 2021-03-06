package domain.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Driver {

    private int ID;
    private StringProperty username = new SimpleStringProperty();
    private StringProperty password = new SimpleStringProperty();
    private StringProperty firstName = new SimpleStringProperty();
    private StringProperty middleName = new SimpleStringProperty();
    private StringProperty lastName = new SimpleStringProperty();
    private StringProperty licNumber = new SimpleStringProperty();
    private StringProperty status = new SimpleStringProperty();
    private StringProperty issuedState = new SimpleStringProperty();
    private StringProperty issuedCountry = new SimpleStringProperty();
    private LogbookList logbookList;
    private boolean isAdmin;

    public Driver(int ID, String username, String password, String firstName, String middleName, String lastName, String licNumber, String status, String issuedState, String issuedCountry, boolean isAdmin, LogbookList logbookList) {
        setID( ID );
        setUsername( username );
        this.password.set( password );
        setFirstName( firstName );
        setMiddleName( middleName );
        setLastName( lastName );
        setLicNumber( licNumber );
        setStatus( status );
        setIssuedState( issuedState );
        setIssuedCountry( issuedCountry );
        setAdmin( isAdmin );
        setLogbookList( logbookList );
    }


    public String getUsername() {
        return username.get();
    }

    public boolean checkPassword(String checkingPassword) {
        return password.get().equals( checkingPassword );
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set( username );
    }

    public String getFirstName() {
        return firstName.get();
    }

    public StringProperty firstNameProperty() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName.set( firstName );
    }

    public String getMiddleName() {
        return middleName.get();
    }

    public StringProperty middleNameProperty() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName.set( middleName );
    }

    public String getLastName() {
        return lastName.get();
    }

    public StringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set( lastName );
    }

    public String getLicNumber() {
        return licNumber.get();
    }

    public StringProperty licNumberProperty() {
        return licNumber;
    }

    public void setLicNumber(String licNumber) {
        this.licNumber.set( licNumber );
    }

    public String getStatus() {
        return status.get();
    }

    public StringProperty statusProperty() {
        return status;
    }

    public void setStatus(String status) {
        this.status.set( status );
    }

    public String getIssuedState() {
        return issuedState.get();
    }

    public StringProperty issuedStateProperty() {
        return issuedState;
    }

    public void setIssuedState(String issuedState) {
        this.issuedState.set( issuedState );
    }

    public String getIssuedCountry() {
        return issuedCountry.get();
    }

    public StringProperty issuedCountryProperty() {
        return issuedCountry;
    }

    public void setIssuedCountry(String issuedCountry) {
        this.issuedCountry.set( issuedCountry );
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set( password );
    }

    public void setLogbookList(LogbookList logbookList) {
        this.logbookList = logbookList;
    }

    public LogbookList getLogbookList(){
        return this.logbookList;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "username=" + getUsername() +
                ", password=" + getPassword() +
                '}';
    }
}
