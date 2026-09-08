import { useEffect, useState } from "react";

function App() {

  // For single student
  const [student, setStudent] = useState(null);

  // For all students
  const [students, setStudents] = useState([]);

  // For Bca student
  const [bcaStudents, setBcaStudents] = useState([]);

  // Get single student
  const getSingleStudent = async () => {

    const response = await fetch("http://localhost:8080/student");

    const data = await response.json();

    setStudent(data);
  };

  // Get all students
  const getStudents = async () => {

    const response = await fetch("http://localhost:8080/student");

    const data = await response.json();

    setStudents(data);
  };
  //Get Bca students
  const getBcaStudents = async () => {
    const response = await fetch("http://localhost:8080/student/bca");
    const data = await response.json();
    setBcaStudents(data);
  }

  // Automatically get all students when page loads
  useEffect(() => {
    getSingleStudent;
    getStudents();
    getBcaStudents();
  }, []);

  return (
    <div style={{ padding: "40px" }}>

      {/* Single Student */}
      <h1>Get Single Student</h1>

      <button onClick={getSingleStudent}>
        Get Student
      </button>

      {student && (
        <div>
          <h2>ID : {student.id}</h2>
          <h2>Name : {student.name}</h2>
          <h2>Course : {student.course}</h2>
        </div>
      )}


      {/* Student List */}
      <h1>Student List</h1>

      {students.map((student) => (
        <div key={student.id}>
          <h3>
            {student.name} - {student.course}
          </h3>
        </div>
      ))}

       {/* BCA STUDENTS */}

       <h1>BCA Students</h1>

{bcaStudents.map(student => (
  <div key={student.id}>
    <h3>
      {student.name} - {student.course}
    </h3>
  </div>
))}


    </div>
  );
}

export default App;