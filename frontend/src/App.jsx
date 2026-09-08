
import { useEffect, useState } from "react";

function App(){
  /*
  const[student, setStudent] = useState(null);

  const getStudent = async() => {
    const response = await fetch("http://localhost:8080/student");
    const data = await response.json();
    setStudent(data);
  
  };
  return (
    <div style = {{padding : "40px" }}>
      <button onClick = {getStudent}>
        Get Student
      </button>
      {
        student && (
          <div>
            <h2>ID : {student.id}</h2>
            <h2>Name : {student.name}</h2>
            <h2>Course : {student.course}</h2>
          </div>
        )
      }
    </div>
  ); */
  const[students, setStudents] = useState([]);

  const getStudent = async() => {
    const response = await fetch("http://localhost:8080/student");

    const data = await response.json();
    setStudents(data);
  }; 

  useEffect( () => {
    getStudent();
  }, []);  

  return (
    <div>

      <h1>Student List</h1>

      {
        students.map((student) => (
          <div key={student.id}>
          
            <h3> 
            {student.name} - {student.course}  

            </h3>
          </div>
        ))
      }

    </div>
  );
}
export default App;