import { useState, useEffect } from "react";

const PatientManagement = () => {

    const [desiredTask, setDesiredTask] = useState()

    const changeTask = (e) => {
        setDesiredTask(e.target.value)
    }

    return (
        <div>
            <h2>Patient Management</h2>
            <div>
                <label>Insert New Patient<input type="radio" name="desiredTask" value="insertPatient" onClick={changeTask}/></label>
                <label>View Patient Information<input type="radio" name="desiredTask" value="viewPatientInfo" onClick={changeTask}/></label>
                <label>Schedule Appointment with a Doctor<input type="radio" name="desiredTask" value="scheduleAppointment" onClick={changeTask}/></label>
                <label>Check Previous Diagnoses and Illnesses<input type="radio" name="desiredTask" value="checkPreviousIllnesses" onClick={changeTask}/></label>
                <label>View Schedule Per Doctor<input type="radio" name="desiredTask" value="viewSchedulePerDoctorPerDay" onClick={changeTask}/></label>
            </div>

            {desiredTask == "insertPatient" ? 
                <form>
                    <input type="text" placeholder="Patient Name"/>
                    <input type="text" placeholder="Patient Address"/>
                    <input type="number" placeholder = "SSN" />
                    <label>DOB<input type="date"/></label>
                    <input type="text" placeholder="Blood Type"/>
                    <label>Male<input type="radio" name="gender" value="male"/></label>
                    <label>Female<input type="radio" name="gender" value="female"/></label>
                    <button type="button">Submit</button>
                </form> : null}
            {desiredTask == "viewPatientInfo" ? 
                <div>
                    <input type="number" placeholder="Enter Patient Number"/>
                    <button type="button">Submit</button>
                </div>: null}
            {desiredTask == "scheduleAppointment" ?
                <form>
                    <input type="date"/>
                    <input type='type' placeholder="Consultation Type"/>
                    <input type="notes" placeholder="Notes"/>
                    <button type="button">Submit</button>
                </form>: null}
            {desiredTask == "checkPreviousIllnesses" ? 
                <form>
                    <input type="number" placeholder="Patient Number"/>
                </form>: null}
            {desiredTask == "viewSchedulePerDoctorPerDay" ?
                <div>
                    <input type="number" placeholder="Employee Number of Doctor"/>
                    <input type="date"/>
                </div>
            : null}
        </div>
        
    )
}

export default PatientManagement;