import { useState, useEffect } from "react";

const ClinicStaffManagement = () => {

    const [desiredTask, setDesiredTask] = useState()

    const changeTask = (e) => {
        setDesiredTask(e.target.value)
    }
    const [data, setData] = useState()
    const handleInputChange = (e) => {
        const {name, value} = e.target
        setData((prevData) => ({
            ...prevData,
            [name]: value,
        }))
    }
    console.log(data)

    const insertEmployeeFetch = () => {
        fetch('http://localhost:8080/api/medstaffmgt/add', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        }).then(response => {
            console.log(response)
        }).catch(error => {
            console.log(error)
        })
    }

    const removeEmployee = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/medstaffmgt/remove?empId=${data.empId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json'
                }})
            const retrievedReponse = await response;
            console.log(retrievedReponse)
        } catch (error) {
            console.log(error)
        }
    }

    const [retrievedEmployees, setRetrievedEmployees] = useState([])

    const fetchStaffPerJobType = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/medstaffmgt/viewByJobType?empType=${data.empType}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }})
            const retrievedData = await response.json()
            setRetrievedEmployees(retrievedData)
        } catch (error) {
            console.log(error)
        }
    }
    console.log(retrievedEmployees)

    const renderedEmployees = retrievedEmployees.map(item => (
        <div>
            <h3>Employee Number: {item[2]}</h3>
            <p>Employee Name: {item[0]}</p>
            <p>Employee Type: {item[1]}</p>
            <p>Employee Gender: {item[3]}</p>
            <p>Employee Address: {item[4]}</p>
            <p>Employee Salary: {item[5]}</p>
            <p>Employee Phone Number: {item[6]}</p>
        </div>
    ))

    const scheduleShiftFetch = () => {
        fetch(`http://localhost:8080/api/medstaffmgt/scheduleNurseShift?employeeId=${data.empId}&date=${data.date}&shift=${data.shift}`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
        }).then(response => {
            console.log(response)
        }).catch(error => {
            console.log(error)
        })
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
                    <input type="text" placeholder="Name" name="name" onChange={handleInputChange}/>
                    <input type="number" placeholder="Salary" name="salary" onChange={handleInputChange}/>
                    <div onChange={handleInputChange}>
                        <label>Male</label><input type="radio" name="gender" value="M"/>
                        <label>Female</label><input type="radio" name="gender" value="F"/>
                    </div>
                    <input type="text" placeholder="Address" name="address" onChange={handleInputChange}/>
                    <input type="number" placeholder="SSN" name="ssn" onChange={handleInputChange}/>
                    <input type="number" placeholder="Phone Number" name="phone" onChange={handleInputChange}/>
                    <input type="text" placeholder="Position" name="empType" onChange={handleInputChange}/>
                    <button type="button" onClick={insertEmployeeFetch}>Submit</button>
                </form>
            : null}
            {desiredTask == "removeStaff" ?
                <form>
                    <input type="number" placeholder="Employee Number" name="empId" onChange={handleInputChange}/>
                    <button type="button" onClick={removeEmployee}>Remove</button>
                </form>
            : null}
            {desiredTask == "viewStaffPerJobType" ?
                <div>
                    <form>
                        <input type="text" placeholder="Job Type" name="empType" onChange={handleInputChange}></input>
                        <button type="button" onClick={fetchStaffPerJobType}>Submit</button>
                    </form>
                    {retrievedEmployees !== null ? 
                        <div>
                            <h2>Employee Information</h2>
                            {renderedEmployees}
                        </div> : null}
                </div>
                
            : null}
            {desiredTask == "scheduleShift" ?
                <form>
                    <input type="number" placeholder="Employee Number" name="empId" onChange={handleInputChange}/>
                    <input type="date" name="date" onChange={handleInputChange}/>
                    <input type="number" name="shift" onChange={handleInputChange}/>
                    <button type="button" onClick={scheduleShiftFetch}>Submit</button>
                </form> 
            : null}
        </div>
    )   
}

export default ClinicStaffManagement;