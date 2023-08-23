import React, {useEffect, useState} from "react";
import axios from "axios";
import {Link, useParams} from "react-router-dom";


export default function Home() {
    const [users, setUsers] = useState([]);

    const {id} = useParams();

    useEffect(() => {
        loadUsers();

    }, []);

    const loadUsers = async () => {
        const result = await axios.get("http://localhost:8080/api/v1/user/getUsers");
        setUsers(result.data);
    }

    const deleteUser = async (id) => {
        await axios.delete(`http://localhost:8080/api/v1/user/deleteUser/${id}`);
        loadUsers();
    }

    return (
        <div className="container">
            <div className="py-4">
                <table className="table border shadow">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Address</th>
                        <th>Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        users.map((user, index) => (
                            <tr>
                                <td>{user.id}</td>
                                <td>{user.name}</td>
                                <td>{user.address}</td>
                                <td>
                                    <Link className="btn btn-sm btn-outline-primary mx-1"
                                          to={`/update/${user.id}`}>Edit</Link>
                                    <button className="btn btn-sm btn-outline-danger mx-1"
                                            onClick={() => deleteUser(user.id)}>Delete
                                    </button>
                                </td>
                            </tr>

                        ))
                    }
                    </tbody>
                </table>
            </div>

        </div>
    )
}