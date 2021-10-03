import * as zip from "jszip";

export const processZipFile = (fileDescriptor, funcRemoveCb) =
>
{
    let response = zip.loadAsync(fileDescriptor.file)
        .then(function (zip) {
            console.log(zip.files);
            return "111"
        })
        .catch((e) = > {
        funcRemoveCb(fileDescriptor)
        return null
    }
)
    ;
    return response;
}