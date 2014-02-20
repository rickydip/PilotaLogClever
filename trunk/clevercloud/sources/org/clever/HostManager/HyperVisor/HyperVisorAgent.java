/*
 *  Copyright (c) 2010 Filippo Bua
 *  Copyright (c) 2010 Maurizio Paone
 *  Copyright (c) 2010 Francesco Tusa
 *  Copyright (c) 2010 Massimo Villari
 *  Copyright (c) 2010 Antonio Celesti
 *  Copyright (c) 2010 Antonio Nastasi
 *  Copyright (c) 2012 Marco Carbone
 *
 *  Permission is hereby granted, free of charge, to any person
 *  obtaining a copy of this software and associated documentation
 *  files (the "Software"), to deal in the Software without
 *  restriction, including without limitation the rights to use,
 *  copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the
 *  Software is furnished to do so, subject to the following
 *  conditions:
 *
 *  The above copyright notice and this permission notice shall be
 *  included in all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 *  EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 *  OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 *  NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 *  HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 *  WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 *  FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 *  OTHER DEALINGS IN THE SOFTWARE.
 */
package org.clever.HostManager.HyperVisor;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
//import java.util.logging.Logger;
import org.clever.Common.Communicator.Agent;
import org.clever.Common.Exceptions.CleverException;
import org.clever.Common.XMLTools.ParserXML;
import java.io.FileInputStream;
import org.apache.log4j.Logger;

public class HyperVisorAgent extends Agent {

    private HyperVisorPlugin hypervisor;
    //private Class cl;
    
    
    public HyperVisorAgent() throws CleverException  {
        super();
        
      
    }

    @Override
    public void initialization() throws CleverException {
        if (super.getAgentName().equals("NoName")) {
            super.setAgentName("HyperVisorAgent");
        }
        super.start();
        try 
        {
            
            hypervisor = (HyperVisorPlugin) super.startPlugin("./cfg/configuration_hypervisor.xml","/org/clever/HostManager/HyperVisor/configuration_hypervisor.xml");        
            hypervisor.setOwner(this);
            logger.info("HyperVisorPlugin created ");
            
        } catch (Exception ex) {
            logger.error("HyperVisorPlugin creation failed: " + ex.getMessage());
            this.errorStr=ex.getMessage();
        }
    }

    @Override
    public Class getPluginClass() {
        return cl;
    }

    @Override
    public Object getPlugin() {
         
        return this.pluginInstantiation;
    }

    @Override
    public void shutDown() {
    }

    
  
}