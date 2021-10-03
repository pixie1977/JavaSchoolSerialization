import React from 'react';

import 'react-popper-tooltip/dist/styles.css';
import './FileList.css';

const styles = {
    root: {
        flexGrow: 1,
        minWidth: 300,
    },
    grow: {
        flexGrow: 1,
        textAlign: 'left',
    },
    menuButton: {
        marginLeft: -12,
        marginRight: 20,
    },
};

const FileList = (props) => {
    const {files} = props;
    let listFiles = [];
    if (files !== null) {
        listFiles.push(
            <tr id="capition">
                <td id="name">Имя файла</td>
                <td id="size">Размер</td>
                <td id="type">Тип</td>
            </tr>)
        let mappedListFiles = files.map((item) =>
            <tr id={item.left}>
                <td id="name">{item.name}</td>
                <td id="size">{item.contentLength}</td>
                <td id="type">{item.type}</td>
            </tr>
        );
        listFiles.push(mappedListFiles);
    } else {
        listFiles.push(
            <tr id="empty">
                Нет загруженных файлов
            </tr>)
    }
    return (
        <table id="simple-board">
            <tbody>
            {listFiles}
            </tbody>
        </table>
    );
};

export default FileList;
