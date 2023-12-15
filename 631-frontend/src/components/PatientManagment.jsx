import { useState, useEffect } from "react";

const PatientManagement = () => {

    const [desiredTask, setDesiredTask] = useState()

    const changeTask = (e) => {
        setDesiredTask(e.target.value)
        setRetrievedPatientData(null)
    }

    const [data, setData] = useState()
    const handleInputChange = (e) => {
        const {name, value} = e.target
        setData((prevData) => ({
            ...prevData,
            [name]: value,
        }))
    }

    const insertPatientFetch = () => {
        fetch('http://localhost:8080/api/ptmgt/new', {
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

    const [retrievedPatientData, setRetrievedPatientData] = useState(null)

    const getPatientInfo = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/ptmgt/info/${data.patientNumber}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }})
            const retrievedData = await response.json()
            setRetrievedPatientData(retrievedData)
        } catch (error) {
            console.log(error)
        }
    } 

    const scheduleAppointment = () => {
        fetch(`http://localhost:8080/api/ptmgt/schedule-appointment?doctorId=${data.doctorId}&date=${data.date}&patientId=${data.patientNumber}`, {
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

    const [retrievedConsultations, setRetrievedConsultations] = useState([])
    const [retrievedDiagnoses, setRetrievedDiagnoses] = useState([])

    const fetchPreviousDiagnoses = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/ptmgt/diagnoses/${data.patientNumber}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }})
            const retrievedData = await response.json()
            setRetrievedDiagnoses(retrievedData)
        } catch (error) {
            console.log(error)
        }
    }

    const fetchConsultations = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/ptmgt/consultations?doctorId=${data.doctorId}&date=${data.date}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }})
            const retrievedData = await response.json()
            setRetrievedConsultations(retrievedData)
        } catch (error) {
            console.log(error)
        }
    }

    const renderedDiagnoses = retrievedDiagnoses.map(item => (
        <div>
            <p>Illness code: {item.illnessCode}</p>
            <p>Consultation Date: {item.consultationDate}</p>
            <p>Employee ID: {item.empId}</p>
            <p>Comment: {item.comment}</p>
        </div>
    ))
    console.log(retrievedDiagnoses)
    const renderedConsultations = retrievedConsultations.map(item => (
        <div>
            <p>Consultation Date: {item.consultationDate}</p>
            <p>Patient Name: {item.patientNumber.patientNumber}</p>
            <p>Type: {item.type}</p>
        </div>
    ))

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
                    <input type="text" placeholder="Patient Name" name="name" onChange={handleInputChange}/>
                    <input type="text" placeholder="Patient Address" name="address" onChange={handleInputChange}/>
                    <input type="number" placeholder = "SSN" name="ssn" onChange={handleInputChange}/>
                    <label>DOB<input type="date" name="dob" onChange={handleInputChange}/></label>
                    <input type="text" placeholder="Blood Type" name="bloodType" onChange={handleInputChange}/>
                    <div onChange={handleInputChange}>
                        <label>Male<input type="radio" name="gender" value="M"/></label>
                        <label>Female<input type="radio" name="gender" value="F"/></label>
                    </div>
                    <button type="button" onClick={insertPatientFetch}>Submit</button>
                </form> : null}
            {desiredTask == "viewPatientInfo" ? 
                <div>
                    <input type="number" placeholder="Enter Patient Number" name="patientNumber" onChange={handleInputChange}/>
                    <button type="button" onClick={getPatientInfo}>Submit</button>

                    {retrievedPatientData !== null ? 
                        <div>
                            <h2>Patient Information</h2>
                            <p>Name: {retrievedPatientData.name}</p>
                            <p>Address: {retrievedPatientData.address}</p>
                            <p>Blood Type: {retrievedPatientData.bloodType}</p>
                            <p>Patient Number: {retrievedPatientData.patientNumber}</p>
                            <p>SSN: {retrievedPatientData.ssn}</p>
                            <p>Gender: {retrievedPatientData.gender}</p>
                        </div> : null}
                </div>
                : null}
            {desiredTask == "scheduleAppointment" ?
                <form>
                    <input type="date" name="date" onChange={handleInputChange}/>
                    <input type='number' placeholder="Doctor ID" name="doctorId" onChange={handleInputChange}/>
                    <input type="number" placeholder="Patient Number" name="patientNumber" onChange={handleInputChange}/>
                    <button type="button" onClick={scheduleAppointment}>Submit</button>
                </form>: null}
            {desiredTask == "checkPreviousIllnesses" ? 
                <div>
                    <form>
                        <input type="number" placeholder="Patient Number" name="patientNumber" onChange={handleInputChange}/>
                        <button type="button" onClick={fetchPreviousDiagnoses}>Submit</button>
                    </form>
                    {retrievedDiagnoses !== null ? 
                        <div>
                            <h2>Patient Previous Diagnoses</h2>
                            {renderedDiagnoses}
                        </div> : null}
                </div>: null}
                
            {desiredTask == "viewSchedulePerDoctorPerDay" ?
                <div>
                    <input type="number" placeholder="Doctor ID" name="doctorId" onChange={handleInputChange}/>
                    <input type="date" name="date" onChange={handleInputChange}/>
                    <button type="button" onClick={fetchConsultations}>Submit</button>
                    {retrievedConsultations !== null ? 
                        <div>
                            <h2>Doctor's Consultations</h2>
                            {renderedConsultations}
                        </div> : null}
                </div>
            : null}
        </div>
        
    )
}

export default PatientManagement;