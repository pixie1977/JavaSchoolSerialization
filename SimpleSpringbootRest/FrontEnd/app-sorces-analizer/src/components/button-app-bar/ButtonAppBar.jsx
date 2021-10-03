import React from 'react';
import PropTypes from 'prop-types';
import {withStyles} from '@material-ui/core/styles';
import AppBar from '@material-ui/core/AppBar';
import Toolbar from '@material-ui/core/Toolbar';
import Typography from '@material-ui/core/Typography';
import Button from '@material-ui/core/Button';

import 'react-popper-tooltip/dist/styles.css';
import './ButtonAppBar.css';

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

const ButtonAppBar = (props) => {
    const {classes, setLoadHandler, status, clearFilesCb, startProcessFilesCb, stopProcessFilesCb} = props;
    return (
        <div className={classes.root}>
            <AppBar position="static">
                <div className="kitt-ecosystem__gradient"><img className=" ls-is-cached lazyloaded" decoding="async"
                                                               data-src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxMzY2IiBoZWlnaHQ9IjYiIHZpZXdCb3g9IjAgMCAxMzY2IDYiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPiA8ZGVmcz4gPGxpbmVhckdyYWRpZW50IGlkPSJwcmVmaXhfX2EiIHgxPSIuNTk2JSIgeDI9IjEwMCUiIHkxPSI1MCUiIHkyPSI1MCUiPiA8c3RvcCBvZmZzZXQ9IjAlIiBzdG9wLWNvbG9yPSIjMDBEOTAwIi8+IDxzdG9wIG9mZnNldD0iMTAwJSIgc3RvcC1jb2xvcj0iI0ZGRkYwMCIvPiA8L2xpbmVhckdyYWRpZW50PiA8L2RlZnM+IDxwYXRoIGZpbGw9InVybCgjcHJlZml4X19hKSIgZmlsbC1ydWxlPSJldmVub2RkIiBkPSJNMCAwSDEzNjZWNkgweiIvPiA8L3N2Zz4="
                                                               src="data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHdpZHRoPSIxMzY2IiBoZWlnaHQ9IjYiIHZpZXdCb3g9IjAgMCAxMzY2IDYiIHByZXNlcnZlQXNwZWN0UmF0aW89Im5vbmUiPiA8ZGVmcz4gPGxpbmVhckdyYWRpZW50IGlkPSJwcmVmaXhfX2EiIHgxPSIuNTk2JSIgeDI9IjEwMCUiIHkxPSI1MCUiIHkyPSI1MCUiPiA8c3RvcCBvZmZzZXQ9IjAlIiBzdG9wLWNvbG9yPSIjMDBEOTAwIi8+IDxzdG9wIG9mZnNldD0iMTAwJSIgc3RvcC1jb2xvcj0iI0ZGRkYwMCIvPiA8L2xpbmVhckdyYWRpZW50PiA8L2RlZnM+IDxwYXRoIGZpbGw9InVybCgjcHJlZml4X19hKSIgZmlsbC1ydWxlPSJldmVub2RkIiBkPSJNMCAwSDEzNjZWNkgweiIvPiA8L3N2Zz4="
                                                               alt="Экосистема" role="presentation" aria-hidden="true"/>
                </div>
                <Toolbar>
                    <Typography variant="h6" color="inherit" className={classes.grow}>
                        Sber Code Analizer
                    </Typography>

                    {(status !== 'IN_PROCESS') && <Button
                        color="inherit"
                        onClick={() => {
                            clearFilesCb();
                        }}
                    >
                        ОЧИСТИТЬ
                    </Button>}

                    {(status !== 'IN_PROCESS') && <Button
                        color="inherit"
                        onClick={() => {
                            startProcessFilesCb();
                        }}
                    >
                        АНАЛИЗИРОВАТЬ
                    </Button>}

                    {(status === 'IN_PROCESS') && <Button
                        color="inherit"
                        onClick={() => {
                            stopProcessFilesCb();
                        }}
                    >
                        ОСТАНОВИТЬ
                    </Button>}
                </Toolbar>
            </AppBar>
        </div>
    );
};

ButtonAppBar.propTypes = {
    classes: PropTypes.object.isRequired,
};

export const TopStyledBar = withStyles(styles)(ButtonAppBar);
