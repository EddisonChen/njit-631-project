import './App.css';
import PatientManagement from './components/PatientManagment';
import InPatientManagement from './components/InPatientManagement';
import ClinicStaffManagement from './components/ClinicStaffManagement';
import { useEffect, useState } from 'react';

function App() {

  const [tab, setTab] = useState();

  const switchTab = (e) => {
    setTab(e.target.value)
  }

  return (
    <div>
      <h1>Newark Medical Associates</h1>
      
      <div>
        <label>Patient Management<input type='radio' name="desiredTask" value="patientManagement" onClick={switchTab}/></label>
        <label>In-Patient Management<input type='radio' name="desiredTask" value="inPatientManagement" onClick={switchTab}/></label>
        <label>Clinic Staff Management<input type='radio' name="desiredTask" value="clinicStaffManagement" onClick={switchTab}/></label>
      </div>

      {tab == "patientManagement" ? <PatientManagement/>: null}
      {tab == "inPatientManagement" ? <InPatientManagement/>: null}
      {tab == "clinicStaffManagement" ? <ClinicStaffManagement/>: null}
    </div>
  );
}

export default App;
