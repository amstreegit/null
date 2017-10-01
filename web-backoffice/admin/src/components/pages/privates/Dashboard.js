import React, { Component } from 'react';
import { Link } from 'react-router-dom';

class Dashboard extends Component {
    render() {
        return (
            <div className="Dashboard">
                <div  className="col-2">
                    <div class="btn-group-vertical" style={{ marginTop: "15px"}}>
                        <button type="button" className="btn btn-success">
                            <h3>
                                <i className="fa fa-home" aria-hidden="true"></i>
                            </h3>
                        </button>
                        <button type="button" className="btn btn-success">
                            <h3>
                                <i className="fa fa-clone" aria-hidden="true"></i>
                            </h3>
                        </button>
                        <button type="button" className="btn btn-success">
                            <h3>
                                <i className="fa fa-bar-chart" aria-hidden="true"></i>
                            </h3>
                        </button>
                    </div>
                </div>
            </div>
        );
    }
}

export default Dashboard;
