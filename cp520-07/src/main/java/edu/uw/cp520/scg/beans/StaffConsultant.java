package edu.uw.cp520.scg.beans;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.beans.VetoableChangeSupport;
import java.util.Objects;

import edu.uw.cp520.scg.domain.Consultant;
import edu.uw.cp520.scg.util.PersonalName;

/**
 * The StaffConsultant class for the Invoice/Timecard project.
 * 
 * @author Toby Peterson.
 *
 */
public class StaffConsultant extends Consultant implements
    Comparable<Consultant>, java.io.Serializable, PropertyChangeListener {

    /**
     * The name of the StaffConsultant.
     */
    private PersonalName name;

    /**
     * The pay rate of the StaffConsultant.
     */
    private int payRate;

    /**
     * The sick leave hours for the StaffConsultant.
     */
    private int sickLeaveHours;

    /**
     * The vacation hours for the StaffConsultant.
     */
    private int vacationHours;

    /**
     * The propertyChangeSupport utility property.
     */
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * The vetoableChangeSupport utility property.
     */
    private VetoableChangeSupport vcs = new VetoableChangeSupport(this);

    /**
     * The constructor for the StaffConsultant class.
     * 
     * @param name      The name of the staff consultant.
     * @param rate      The pay rate of the staff consultant.
     * @param sickLeave The sick leave hours for the staff consultant.
     * @param vacation  The vacation hours for the staff consultant.
     */
    public StaffConsultant(PersonalName name, int rate, int sickLeave,
        int vacation) {
        super(name);
        this.payRate = rate;
        this.sickLeaveHours = sickLeave;
        this.vacationHours = vacation;
    }

    /**
     * The getPayRate getter method for the StaffConsultant class.
     * 
     * @return int The pay rate.
     */
    public int getPayRate() {
        return payRate;
    }

    /**
     * The setPayRate setter for the StaffConsultant class. It fires the
     * VetoableChange event and if approved the PropertyChange event.
     * 
     * @param payRate The pay rate to attempt to set.
     * @throws PropertyVetoException The exception that is thrown if the pay
     *                               rate is over 5%.
     */
    public void setPayRate​(int payRate) throws PropertyVetoException {
        vcs.fireVetoableChange("payRate", this.payRate, payRate);
        int oldValue = this.payRate;
        this.payRate = payRate;
        pcs.firePropertyChange("payRate", oldValue, payRate);
    }

    /**
     * The addPrepertyChangeListener method. It adds a general property change
     * listener.
     * 
     * @param l The listener to be added.
     */
    public void addPropertyChangeListener​(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    /**
     * The removePrepertyChangeListener method. It removes a general property
     * change listener.
     * 
     * @param l The listener to be removed.
     */
    public void removePropertyChangeListener​(PropertyChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }

    /**
     * The addPrepertyChangeListener method. It adds a general property change
     * listener.
     * 
     * @param l The listener to be added.
     */
    public void addPayRateListener​(PropertyChangeListener l) {
        this.pcs.addPropertyChangeListener("payRate", l);
    }

    /**
     * The removePayRateListener method. It removes a listener that is bound to
     * the payRate property.
     * 
     * @param l The listener to be removed.
     */
    public void removePayRateListener​(PropertyChangeListener l) {
        this.pcs.removePropertyChangeListener("payRate", l);
    }

    /**
     * The addVetoableChangeListener method. It adds a vetoablechange listener.
     * 
     * @param l The listener to be added.
     */
    public void addVetoableChangeListener​(VetoableChangeListener l) {
        vcs.addVetoableChangeListener("payRate", l);
    }

    /**
     * The removeVetoableChangeListener method. It removes a listener that is
     * bound to the payRate property.
     * 
     * @param l The listener to be removed.
     */
    public void removeVetoableChangeListener​(VetoableChangeListener l) {
        vcs.removeVetoableChangeListener("payRate", l);

    }

    /**
     * The getSickLeaveHours getter method.
     * 
     * @return int The sickleave hours for the staff consultant.
     */
    public int getSickLeaveHours() {
        return sickLeaveHours;
    }

    /**
     * The setSickLeaveHours setter method for StaffConsultant.
     * 
     * @param sickLeaveHours The sickleave hours that is to be the new value.
     */
    public void setSickLeaveHours​(int sickLeaveHours) {
        int oldValue = this.sickLeaveHours;
        int newValue = sickLeaveHours;
        this.pcs.firePropertyChange("sickLeaveHours", oldValue, newValue);
    }

    /**
     * The addPrepertyChangeListener method. It adds a general property change
     * listener.
     * 
     * @param l The listener to be added.
     */
    public void addSickLeaveHoursListener​(PropertyChangeListener l) {
        this.pcs.addPropertyChangeListener("sickLeaveHours", l);

    }

    /**
     * The removeSickLeaveHoursListener method. It removes the listener that is
     * bound to the sickLeaveHours property.
     * 
     * @param l The listener to be removed.
     */
    public void removeSickLeaveHoursListener​(PropertyChangeListener l) {
        this.pcs.removePropertyChangeListener("sickLeaveHours", l);

    }

    /**
     * The getVacationHours getter method.
     * 
     * @return int The vacation hours for the staff consultant.
     */
    public int getVacationHours() {
        return vacationHours;
    }

    /**
     * The setVacationHours getter method. It sets the vacation hours.
     * 
     * @param vacationHours The vacationHours to set as the new value.
     */
    public void setVacationHours​(int vacationHours) {
        int oldValue = getVacationHours();
        int newValue = vacationHours;
        this.pcs.firePropertyChange("vacationHours", oldValue, newValue);
    }

    /**
     * The addVacationHoursistener method. It adds a listener to the
     * vacationHours property
     * 
     * @param l The listener to be added.
     */
    public void addVacationHoursListener​(PropertyChangeListener l) {
        this.pcs.addPropertyChangeListener("vacationHours", l);
    }

    /**
     * The removeVacationHoursListener method. It adds a propertyChangeListener
     * to the vacation hours property.
     * 
     * @param l The listener to be added.
     */
    public void removeVacationHoursListener​(PropertyChangeListener l) {
        this.pcs.removePropertyChangeListener("vacationHours", l);
    }

    /**
     * The hashCode method. It propduces a hashcode from the object's
     * properties.
     * 
     * @param int The hashcode.
     */
    @SuppressWarnings("javadoc")
    @Override
    public int hashCode() {
        return Objects.hash(name, payRate, sickLeaveHours, vacationHours);
    }

    /**
     * The equals method for the StaffConsultant class.
     * 
     * @param boolean The boolean value that indicates whether or not two
     *                StaffConsultant objects are equal.
     */
    @SuppressWarnings("javadoc")
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!(obj instanceof StaffConsultant))
            return false;
        StaffConsultant other = (StaffConsultant) obj;
        return Objects.equals(name, other.name) && payRate == other.payRate
            && sickLeaveHours == other.sickLeaveHours
            && vacationHours == other.vacationHours;
    }

    /**
     * The propertyChange method. It simply logs the change.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
    }

}
