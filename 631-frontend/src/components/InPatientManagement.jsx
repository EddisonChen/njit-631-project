import { useState, useEffect } from "react";

const InPatientManagement = () => {

    const [desiredTask, setDesiredTask] = useState()

    const changeTask = (e) => {
        setDesiredTask(e.target.value)
    }
    
    return (
        <div>
            <h2>In-Patient Management</h2>
            <div>
                <label>Check For Available Room</label><input type="radio" name="desiredTask" value="checkForBed" onClick={changeTask}/>
                <label>Assign/Remove Patient to Bed</label><input type="radio" name="desiredTask" value="patientToBed" onClick={changeTask}/>
                <label>Assign/Remove Doctor to/From Patient</label><input type="radio" name="desiredTask" value="patientToDoctor" onClick={changeTask}/>
                <label>Assign/Remove Nurse to/From Patient</label><input type="radio" name="desiredTask" value="patientToNurse" onClick={changeTask}/>
                <label>View Surgery Schedule Per Room Per Day</label><input type="radio" name="desiredTask" value="surgerySchedulePerRoomPerDay" onClick={changeTask}/>
                <label>View Surgery Schedule Per Surgeon per Day</label><input type="radio" name="desiredTask" value="surgerySchedulePerSurgeonPerDay" onClick={changeTask}/>
                <label>Book a Surgery</label><input type="radio" name="desiredTask" value="bookSurgery" onClick={changeTask}/>
                <label>View Scheduled Surgery Per Patient</label><input type="radio" name="desiredTask" value="surgerySchedulePerPatient" onClick={changeTask}/>
            </div>

            {desiredTask == "checkForBed" ? 
                <button type="button">Find Available Bed</button>: null}
            {desiredTask == "patientToBed" ? 
                <form>
                    <input type="number" placeholder="Patient Number"/>
                    <input type="text" placeholder="BedID"/>
                    <button type="button">Assign</button>
                    <button type="button">Remove</button>
                </form>
                : null}
            {desiredTask == "patientToDoctor" ? 
                <form>
                    <input type="number" placeholder="Patient Number"/>
                    <input type="text" placeholder="Doctor Employee Number"/>
                    <button type="button">Assign</button>
                    <button type="button">Remove</button>
                </form>
                : null}
            {desiredTask == "patientToNurse" ? 
                <form>
                    <input type="number" placeholder="Patient Number"/>
                    <input type="text" placeholder="Nurse Employee Number"/>
                    <button type="button">Assign</button>
                    <button type="button">Remove</button>
                </form>: null}
            {desiredTask == "surgerySchedulePerRoomPerDay" ? 
                <form>
                    <input type="number" placeholder="Room Number"/>
                    <input type="date"/>
                </form>: null}
            {desiredTask == "surgerySchedulePerSurgeonPerDay" ?
                <form>
                    <input type="number" placeholder="Surgeon Employee Number"/>
                    <input type="date"/>
                </form>: null}
            {desiredTask == "bookSurgery" ? 
                <form>
                    <input type="number" placeholder="Patient Number"/>
                    <input type="date"/>
                    <input type="text" placeholder="Type"/>
                </form>: null}
            {desiredTask == "surgerySchedulePerPatient" ? 
                <form>
                    <input type="number" placeholder="Patient Number"/>
                </form>: null}        
        </div>
        
    )
}

export default InPatientManagement;