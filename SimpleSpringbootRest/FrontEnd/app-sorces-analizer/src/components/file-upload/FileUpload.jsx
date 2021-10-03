import UploadDropZone from '@rpldy/upload-drop-zone';
import Uploady, {useItemFinishListener, useItemStartListener} from "@rpldy/uploady";
import './FileUpload.css';
import * as React from "react";

const corsHeaders = new Headers();
corsHeaders.append('Access-Control-Allow-Origin', '*')

const FileUploadContent = (props) => {

    useItemStartListener(item => {
        // console.log(
        //     `item ${item.id} started uploading. file name = ${item.file.name}`
        // );
    });
    useItemFinishListener(item => {
        // console.log(
        //     `item ${item.id} finished uploading. response = `,
        //     item.uploadResponse
        // );
        props.onCompleteFileUploadHandler(item);
    });
    return (
        <UploadDropZone
            className="height200"
            onDragOverClassName="drag-over"
            htmlDirContentParams={{recursive: true}}
            dropHanler={(o) => console.log("upload complete " + o)}
        >
            <div className="upload-zone"> Переместите файлы или папки мышью сюды</div>
        </UploadDropZone>

    )
}

export default function FileUpload(props) {
    return (
        <Uploady
            destination={{url: "http://localhost:8081/loadFile", credentials: "include", headers: corsHeaders}}
        >
            <FileUploadContent onCompleteFileUploadHandler={props.onCompleteFileUploadHandler}/>
        </Uploady>
    );
}
