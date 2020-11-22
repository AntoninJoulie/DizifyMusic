import React from 'react';

import axios from 'axios';

export default class Album extends React.Component {
    state = {
        albums: []
    }

    componentDidMount() {
        axios.get(`http://app-a51b6977-2b64-4d92-b8f7-dc0fba52d462.cleverapps.io/album`)
            .then(res => {
                const albums = res.data;
                this.setState({ albums });
            })
    }

    render() {
        return (
            <ul>
                { this.state.albums.map(album => <li>{album.albumNom}</li>) }
            </ul>
        )
    }
}