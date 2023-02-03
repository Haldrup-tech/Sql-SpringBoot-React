const React = require('react');
const ReactDOM = require('react-dom');
const Client = require('./client');
class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {majreqs: []};
  }

  componentDidMount() {
    Client({method: 'GET', path: '/demo/all/majreq'}).done(response =>{
      this.setState({majreqs: response.entity});
    });
  }

  render() {
    return (<MajReqList majreqs = {this.state.majreqs}/>)
  }
}

class MajReqList extends React.Component {
  render() {
    const majreq = this.props.majreqs.map(majreq => <MajReq key={majreq.id} majreq = {majreq}/>
    );
    return (
      <table>
        <tbody>
          <tr>
            <th>Major ID</th>
            <th>Major Name</th>
            <th>Major Req Type</th>
            <th>Class Name</th>
          </tr>
          {majreq}
        </tbody>
      </table>
    )
  }
}

class MajReq extends React.Component {
  render() {
    return (
      <tr>
        <td>{this.props.majreq.majorId}</td>
        <td>{this.props.majreq.major}</td>
        <td>{this.props.majreq.majorReqs}</td>
        <td>{this.props.majreq.className}</td>
      </tr>
    )
  }
}

import { createRoot } from 'react-dom/client';
const container = document.getElementById('react');
const root = createRoot(container);
root.render(<App />);