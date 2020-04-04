import React, { useState, useEffect, useCallback } from 'react';
import { useDropzone } from 'react-dropzone'
import axios from 'axios';
import './App.css';

const UserProfiles = () => {
  const noimg = require('./resources/sem-foto.png')
  const [userProfiles, setUserProfiles] = useState([]);
  const fetchUserProfiles = () => {
    axios.get("http://localhost:8080/api/user").then(res => {
      setUserProfiles(res.data);
    });
  };

  useEffect(() => {
    fetchUserProfiles();
  }, []);

  return userProfiles.map((userProfile, index) => {
    return (
      <div key={index}>
        <br />
        {userProfile.userProfileImage ? <img src={`http://localhost:8080/api/user/${userProfile.userID}/img/download`} /> : <img src={noimg} />}
        <br />
        <h1>{userProfile.userName}</h1>
        <p>{userProfile.userID}</p>
        <MyDropzone {...userProfile} />
        <br />
      </div>
    );
  })
};

function MyDropzone({ userID }) {
  const onDrop = useCallback(acceptedFiles => {
    const file = acceptedFiles[0];

    const formData = new FormData();
    formData.append("file", file);

    axios.post(`http://localhost:8080/api/user/${userID}/img/upload`,
      formData, {
      headers: {
        "Content-Type": "multipart/form-data"
      }
    }).then(() => {
      window.location.reload(false);
    }).catch(err => {
      console.log(err);
    });
  }, [])
  const { getRootProps, getInputProps, isDragActive } = useDropzone({ onDrop })

  return (
    <div {...getRootProps()}>
      <input {...getInputProps()} />
      {
        isDragActive ?
          <p>Drop the image here ...</p> :
          <p>Drag 'n' drop your photo, or click to select it!</p>
      }
    </div>
  )
}

function App() {
  return (
    <div className="App">
      <UserProfiles />
    </div>
  );
}

export default App;