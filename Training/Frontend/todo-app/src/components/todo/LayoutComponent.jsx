import React from 'react';
import HeaderComponent from './HeaderComponent';
import FooterComponent from './FooterComponent';
import { Outlet } from 'react-router-dom';

const LayoutComponent = () => {
    return (
        <div>
            <HeaderComponent />
            <main>
                <Outlet />
            </main>
            <FooterComponent />
        </div>
    );
};

export default LayoutComponent;
