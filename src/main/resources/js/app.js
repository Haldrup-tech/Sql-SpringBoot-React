const React = require('react');
const ReactDOM = require('react-dom');
const Client = require('./client');

class App extends React.Component {
  constructor(props) {
    super(props);
    this.state = {users: []};
  }

  componentDidMount() {
    Client({method: 'GET', path: '/demo/all'}).done(response =>{
      this.setState({users: response.entity});
    });
  }

  render() {
    return (<UserList users = {this.state.users}/>)
  }
}

class UserList extends React.Component {
  render() {
    const users = this.props.users.map(user => <User key={user.id} user = {user}/>
    );
    return (
      
      <table>
        <tbody>
          <tr>
            <th>id</th>
            <th>name</th>
            <th>email</th>
          </tr>
          {users}
        </tbody>
      </table>
    )
  }
}

class User extends React.Component {
  render() {
    return (
      <tr>
        <td>{this.props.user.id}</td>
        <td>{this.props.user.name}</td>
        <td>{this.props.user.email}</td>
      </tr>
    )
  }
}

import { createRoot } from 'react-dom/client';
const container = document.getElementById('react');
const root = createRoot(container);
root.render(<App />);
