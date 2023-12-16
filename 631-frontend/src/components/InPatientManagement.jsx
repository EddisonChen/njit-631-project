import { useState, useEffect } from "react";

const InPatientManagement = () => {

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

    const [retrievedBeds, setRetrievedBeds] = useState([])

    const fetchAvailableBeds = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/inptmgt/available-beds`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }})
            const retrievedData = await response.json()
            setRetrievedBeds(retrievedData)
        } catch (error) {
            console.log(error)
        }
    }
    const renderedBeds = retrievedBeds.map(item => (
        <div key={item.bedId}>
            <h3>Bed ID: {item.bedId}</h3>
            <p>Bed Letter: {item.bedLetter}</p>
            <p>Room Number: {item.roomNumber}</p>
            <p>Wing: {item.wing}</p>
            <p>Unit: {item.unit}</p>
        </div>
    ))

    const assignPatientToBed = () => {
        fetch(`http://localhost:8080/api/inptmgt/assign-patient-to-bed?patientId=${data.patientId}&bedId=${data.bedId}`, {
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
    const removePatientFromBed = () => {
        fetch(`http://localhost:8080/api/inptmgt/remove-patient-from-bed?patientId=${data.patientId}&bedId=${data.bedId}`, {
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

    const assignDoctorToPatient = () => {
        fetch(`http://localhost:8080/api/inptmgt/assign-doctor-to-patient?doctorId=${data.doctorId}&patientId=${data.patientId}`, {
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
    const removeDoctorFromPatient = () => {
        fetch(`http://localhost:8080/api/inptmgt/remove-doctor-from-patient?doctorId=${data.doctorId}&patientId=${data.patientId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
        }).then(response => {
            console.log(response)
        }).catch(error => {
            console.log(error)
        })
    }

    const assignNurseToPatient = () => {
        fetch(`http://localhost:8080/api/inptmgt/assign-nurse-to-patient?nurseId=${data.nurseId}&patientId=${data.patientId}&shift=${data.shift}&date=${data.date}`, {
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
    const removeNurseFromPatient = () => {
        fetch(`http://localhost:8080/api/inptmgt/remove-nurse-from-patient?nurseId=${data.nurseId}&patientId=${data.patientId}&shift=${data.shift}&date=${data.date}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json'
            },
        }).then(response => {
            console.log(response)
        }).catch(error => {
            console.log(error)
        })
    }

    const [retrievedSurgery, setRetrievedSurgery] = useState([])

    const fetchSurgeryPerRoomPerDay = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/inptmgt/view-scheduled-surgery-per-room-per-day?theater=${data.theater}&date=${data.date}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }})
            const retrievedData = await response.json()
            setRetrievedSurgery(retrievedData)
        } catch (error) {
            console.log(error)
        }
    }

    const renderedSurgeries = retrievedSurgery.map(item => (
        <div>
            <h3>Surgeon ID: {item[0]}</h3>
            <p>Patient ID: {item[1]}</p>
        </div>
    ))

    const bookSurgery = () => {
        fetch(`http://localhost:8080/api/inptmgt/book-surgery?patientId=${data.patientId}&theater=${data.theater}&date=${data.date}&staffIds=${data.staffId}`, {
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

    const [retrievedPatientSurgeries, setRetrievedPatientSurgeries] = useState([])

    const fetchSurgeryPerPatient = async () => {
        try {
            const response = await fetch(`http://localhost:8080/api/inptmgt/view-scheduled-surgeries-per-patient?patientNumber=${data.patientId}`, {
                method: 'GET',
                headers: {
                    'Content-Type': 'application/json'
                }})
            const retrievedData = await response.json()
            setRetrievedPatientSurgeries(retrievedData)
        } catch (error) {
            console.log(error)
        }
    }

    const renderedPatientSurgeries = retrievedPatientSurgeries.map(item => (
        <div>
            <h3>Surgeon ID: {item[0]}</h3>
            <p>Date: {item[1]}</p>
            <p>Theater: {item[1]}</p>
        </div>
    ))
    
    return (
        <div>
            <h2>In-Patient Management</h2>
            <div>
                <label>Check For Available Beds</label><input type="radio" name="desiredTask" value="checkForBed" onClick={changeTask}/>
                <label>Assign/Remove Patient to Bed</label><input type="radio" name="desiredTask" value="patientToBed" onClick={changeTask}/>
                <label>Assign/Remove Doctor to/From Patient</label><input type="radio" name="desiredTask" value="patientToDoctor" onClick={changeTask}/>
                <label>Assign/Remove Nurse to/From Patient</label><input type="radio" name="desiredTask" value="patientToNurse" onClick={changeTask}/>
                <label>View Surgery Schedule Per Room Per Day</label><input type="radio" name="desiredTask" value="surgerySchedulePerRoomPerDay" onClick={changeTask}/>
                {/* <label>View Surgery Schedule Per Surgeon per Day</label><input type="radio" name="desiredTask" value="surgerySchedulePerSurgeonPerDay" onClick={changeTask}/> */}
                <label>Book a Surgery</label><input type="radio" name="desiredTask" value="bookSurgery" onClick={changeTask}/>
                <label>View Scheduled Surgery Per Patient</label><input type="radio" name="desiredTask" value="surgerySchedulePerPatient" onClick={changeTask}/>
            </div>

            {desiredTask == "checkForBed" ? 
                <div>
                    <button type="button" onClick={fetchAvailableBeds}>Find Available Bed</button>
                    {renderedBeds}
                </div>: null}
            {desiredTask == "patientToBed" ? 
                <form>
                    <input type="number" placeholder="Patient Number" name="patientId" onChange={handleInputChange}/>
                    <input type="text" placeholder="BedId" name="bedId" onChange={handleInputChange}/>
                    <button type="button" onClick={assignPatientToBed}>Assign</button>
                    <button type="button" onClick={removePatientFromBed}>Remove</button>
                </form>
                : null}
            {desiredTask == "patientToDoctor" ? 
                <form>
                    <input type="number" placeholder="Patient Number" name="patientId" onChange={handleInputChange}/>
                    <input type="number" placeholder="Doctor Employee Number" name="doctorId" onChange={handleInputChange}/>
                    <button type="button" onClick={assignDoctorToPatient}>Assign</button>
                    <button type="button" onClick={removeDoctorFromPatient}>Remove</button>
                </form>
                : null}
            {desiredTask == "patientToNurse" ? 
                <form>
                    <input type="number" placeholder="Patient Number" name="patientId" onChange={handleInputChange}/>
                    <input type="number" placeholder="Nurse Employee Number" name="nurseId" onChange={handleInputChange}/>
                    <input type="date" name="date" onChange={handleInputChange}/>
                    <input type="number" name="shift" onChange={handleInputChange}/>
                    <button type="button" onClick={assignNurseToPatient}>Assign</button>
                    <button type="button" onClick={removeNurseFromPatient}>Remove</button>
                </form>: null}
            {desiredTask == "surgerySchedulePerRoomPerDay" ?
                <div>
                    <form>
                        <input type="number" placeholder="Room Number" name="theater" onChange={handleInputChange}/>
                        <input type="date" name="date" onChange={handleInputChange}/>
                        <button type="button" onClick={fetchSurgeryPerRoomPerDay}>Submit</button>
                    </form>
                    {renderedSurgeries}
                </div>: null}
            {desiredTask == "bookSurgery" ? 
                <form>
                    <input type="number" placeholder="Patient Number" name="patientId" onChange={handleInputChange}/>
                    <input type="date" name="date" onChange={handleInputChange}/>
                    <input type="number" placeholder="Theater" name="theater" onChange={handleInputChange}/>
                    <input type="number" placeholder="Surgeon Id" name="staffId"  onChange={handleInputChange}/>
                    <button type="button" onClick={bookSurgery}>Submit</button>
                </form>: null}
            {desiredTask == "surgerySchedulePerPatient" ?
                <div>
                    <form>
                        <input type="number" placeholder="Patient Number" name="patientId" onChange={handleInputChange}/>
                        <button type="button" onClick={fetchSurgeryPerPatient}>Submit</button>
                    </form>
                    {renderedPatientSurgeries}
                </div>: null}       
        </div>
        
    )
}

export default InPatientManagement;