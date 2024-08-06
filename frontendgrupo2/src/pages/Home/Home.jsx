import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { getSunTimes } from '../../services/SunService';
import { getCurrentTemperatureExtra } from '../../services/WeatherService';
import { getCurrentTemperature, getSunrise, getSunset } from "../../services/TempWeatherService.jsx";
import '../../styles/Home.css';
import '@fortawesome/fontawesome-free/css/all.min.css'; // Import Font Awesome

/**
 * Home is a functional component that renders the home page.
 * It uses the useState and useEffect hooks to manage the state of the sun times, temperature, current time, and current year.
 * It also uses the useNavigate hook from react-router-dom to navigate to the rooms page.
 *
 * @component
 * @example
 * return (
 *   <Home />
 * )
 */
const Home = () => {
    const [sunTimes, setSunTimes] = useState({});
    const [sunrise, setSunrise] = useState(null);
    const [sunset, setSunset] = useState(null);
    const [temperature, setTemperature] = useState(null);
    const [currentTime, setCurrentTime] = useState(new Date());
    const currentYear = new Date().getFullYear();
    const navigate = useNavigate();

    useEffect(() => {
        const fetchSunTimes = async () => {
            const lat = 41.1496; // Latitude for Porto
            const lng = -8.6110; // Longitude for Porto
            try {
                const sunrise = await getSunrise(lat, lng);
                setSunrise(sunrise);
                const sunset = await getSunset(lat, lng);
                setSunset(sunset);
            } catch (error) {
                try {
                    const data = await getSunTimes(lat, lng);
                    setSunrise(new Date(data.sunrise).toLocaleTimeString([], {
                        hour: '2-digit',
                        minute: '2-digit'
                    }));
                    setSunset(new Date(data.sunset).toLocaleTimeString([], {
                        hour: '2-digit',
                        minute: '2-digit'
                    }));
                } catch (error) {
                    console.error('Error fetching sun times:', error);
                }
            }
        };
        fetchSunTimes();
    }, []);

    useEffect(() => {
        const fetchTemperature = async () => {
            const lat = 41.1496; // Latitude for Porto
            const lon = -8.6110; // Longitude for Porto
            try {
                const temp = await getCurrentTemperature(lat, lon);
                setTemperature(temp);
            } catch (error) {
                try {
                    const temp = await getCurrentTemperatureExtra(lat, lon);
                    setTemperature(temp);
                } catch (error) {
                    console.error('Error fetching temperature:', error);
                }
            }
        };

        fetchTemperature(); // Initial fetch

        const intervalId = setInterval(fetchTemperature, 15 * 60 * 1000); // Update every 15 minutes
        return () => clearInterval(intervalId); // Cleanup interval on component unmount
    }, []);

    useEffect(() => {
        const intervalId = setInterval(() => {
            setCurrentTime(new Date());
        }, 1000); // 1000 milliseconds = 1 second

        return () => clearInterval(intervalId); // Cleanup interval on component unmount
    }, []);

    const navigateToRoomMenu = () => {
        navigate('/rooms');
    };

    return (
        <div className="container">
            <div className="home-card">
                <div className="header">
                    <h1>Smart Home</h1>
                    <p className="time">{currentTime.toLocaleTimeString()}</p>
                </div>
                <div className="content">
                    <p className="date">{currentTime.toLocaleDateString(undefined, {
                        month: 'long',
                        day: 'numeric',
                        year: 'numeric'
                    })}</p>
                    {temperature !== null ? (
                        <p className="temperature">{temperature}°C</p>
                    ) : (
                        <p className="loading">Loading temperature...</p>
                    )}
                    <button className="home-button" onClick={navigateToRoomMenu}>
                        <i className="fas fa-home"></i>
                    </button>
                    {/* Add the login button here */}
                    <a href="http://localhost:8080/oauth2/authorization/github">
                        <button className="login-button">Login with GitHub</button>
                    </a>
                </div>
                {sunrise && sunset ? (
                    <div className="sun-times">
                        <p className="sunrise">Sunrise: {sunrise}</p>
                        <p className="sunset">Sunset: {sunset}</p>
                    </div>
                ) : (
                    <p className="loading">Loading sun times...</p>
                )}
            </div>
            <footer className="footer">
                © {currentYear} SmartHome Grupo 2. All rights reserved.
            </footer>
        </div>
    );
};

export default Home;
