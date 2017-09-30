import React, { Component } from 'react';

class Dashboard extends Component {
    showSettings (event) {
        event.preventDefault();
    }

    render() {
        return (
            <div className="Dashboard">
                <ol className="breadcrumb">
                    <li className="breadcrumb-item"><a href="#">Home</a></li>
                    <li className="breadcrumb-item"><a href="#">Library</a></li>
                    <li className="breadcrumb-item active">Data</li>
                </ol>
            </div>
        );
    }
}

export default Dashboard;
