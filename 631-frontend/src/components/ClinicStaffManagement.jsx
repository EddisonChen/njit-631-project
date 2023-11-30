import { useState, useEffect } from "react";

const ClinicStaffManagement = () => {

    const [desiredTask, setDesiredTask] = useState()

    const changeTask = (e) => {
        setDesiredTask(e.target.value)
    }

    return (
        <div>
            <h2>Clinic Staff Management</h2>
            <div>
                <label>Add Staff Member</label><input type="radio" name="desiredTask" value="addStaff" onClick={changeTask}/>
                <label>Remove Staff Member</label><input type="radio" name="desiredTask" value="removeStaff" onClick={changeTask}/>
                <label>View Staff Member per Job Type</label><input type="radio" name="desiredTask" value="viewStaffPerJobType" onClick={changeTask}/>
                <label>Schedule Job Shift</label><input type="radio" name="desiredTask" value="scheduleShift" onClick={changeTask}/>
            </div>

            {desiredTask == "addStaff" ?
                <form>
                    <input type="text" placeholder="Name"/>
                    <input type="number" placeholder="Salary"/>
                    <label>Male</label><input type="radio" name="gender" value="male"/>
                    <label>Female</label><input type="radio" name="gender" value="female"/>
                    <input type="text" placeholder="Address"/>
                    <input type="number" placeholder="SSN"/>
                    <input type="number" placeholder="Phone Number"/>
                    <input type="text" placeholder="Position"/>
                </form>
            : null}
            {desiredTask == "removeStaff" ?
                <form>
                    <input type="number" placeholder="Employee Number"/>
                    <button type="button">Remove</button>
                </form>
            : null}
            {desiredTask == "viewStaffPerJobType" ?
                <form>
                    <input type="text" placeholder="Job Type"></input>
                </form>
            : null}
            {desiredTask == "scheduleShift" ?
                <form>
                    <input type="number" placeholder="Employee Number"/>
                    <input type="date"/>
                </form> 
            : null}
        </div>
    )   
}

export default ClinicStaffManagement;