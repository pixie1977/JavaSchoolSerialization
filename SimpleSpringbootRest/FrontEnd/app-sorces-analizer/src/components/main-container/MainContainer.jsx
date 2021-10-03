import React, {useEffect, useState} from 'react';
import {createTheme, ThemeProvider} from '@material-ui/core/styles';
import {red} from '@material-ui/core/colors';
import './MainContainer.css';
import CssBaseline from "@material-ui/core/es/CssBaseline/CssBaseline";
import {TopStyledBar} from "../button-app-bar/ButtonAppBar";
import FileUpload from "../file-upload/FileUpload";
import axios from 'axios';
import FileList from "../file-list/FileList";
import ProgressBar from "@ramonak/react-progress-bar";

// A custom theme for this app
const theme = createTheme({
    palette: {
        primary: {
            main: '#556cd6',
        },
        secondary: {
            main: '#19857b',
        },
        error: {
            main: red.A400,
        },
        background: {
            default: 'white',
        },
    },
});

export const MainContainer = () => {
    const [files, setFiles] = useState(null);
    const [status, setStatus] = useState(null);
    const [progress, setProgress] = useState(0);

    const updateFiles = () => {
        axios.get(`http://localhost:8081/getFiles`)
            .then(res => {
                const data = res.data;
                setFiles(data);
            })
    }

    const updateProgress = () => {
        axios.get(`http://localhost:8081/getProgress`)
            .then(res => {
                const data = res.data;
                setProgress(data);
                updateStatus();
            })
    }

    const updateStatus = () => {
        axios.get(`http://localhost:8081/getStatus`)
            .then(res => {
                const data = res.data;
                setStatus(data);
            })
    }

    const clearFiles = () => {
        axios.post(`http://localhost:8081/clear`)
            .then(res => {
                updateFiles();
                updateStatus();
            })
    }

    const startProcessFiles = () => {
        axios.post(`http://localhost:8081/startProcessing`)
            .then(res => {
                updateFiles();
                updateStatus();
            })
    }

    const stopProcessFiles = () => {
        axios.post(`http://localhost:8081/stopProcessing`)
            .then(res => {
                updateFiles();
                updateStatus();
            })
    }

    useEffect(() => {
        const timerId = setInterval(() => updateProgress(), 1000);
        return () => clearInterval(timerId);
    });

    return (
        <div data-node="main-container" className="mainContainer">
            <ThemeProvider theme={theme}>
                <CssBaseline/>
                <TopStyledBar
                    status={status}
                    clearFilesCb={clearFiles}
                    startProcessFilesCb={startProcessFiles}
                    stopProcessFilesCb={stopProcessFiles}
                />
                {(status !== 'IN_PROCESS') && <FileUpload
                    onCompleteFileUploadHandler={updateFiles}
                />}
                <FileList files={files}/>
                {(status === 'IN_PROCESS') && <ProgressBar completed={progress}/>}
            </ThemeProvider>
        </div>
    );
};

