import axios from "axios";
import React, { useEffect, useState } from "react";

const List = () => {
  const [Users, setUsers] = useState([]);

  useEffect(() => {
    loadUsers();
  }, []);

  // get all users
  const loadUsers = async () => {
    const resulte = await axios.get(`http://localhost:9090/users`, {
      validateStatus: () => {
        return true;
      },
    });
    if (resulte.status === 302) {
      console.log(resulte.data);
      setUsers(resulte.data);
    }
  };
  return (
    <section className="mt-5  mx-4">
      <table className="table table-bordered ">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Email</th>
            <th scope="col">Depratment</th>
            <th scope="col">Action</th>
          </tr>
        </thead>
        <tbody>
          {Users.map((user, key) => (
            <tr key={user.id}>
              <th scope="row" key={key}>
                {key + 1}
              </th>
              <td>{user.firstname}</td>
              <td>{user.lastname}</td>
              <td>{user.email}</td>
              <td>{user.departemnt}</td>
              <td>
                <button type="button" className="btn btn-sm btn-primary mx-2">
                  Profile
                </button>
                <button type="button" className="btn btn-sm btn-secondary mx-2">
                  Update
                </button>
                <button type="button" className="btn  btn-sm btn-success mx-2">
                  Delete
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </section>
  );
};

export default List;
