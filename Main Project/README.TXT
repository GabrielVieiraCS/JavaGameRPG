Backup code:

case "playerCombatS":
                switch(playerChoice)
                {
                    case "c1": 
                        if(enemyHPS<1)
                        {
                            win();
                        }
                        else
                        {
                            enemyCombatS();
                        }
                     break;
                } break;
            
            case "enemyCombatS":
                switch(playerChoice)
                {
                    case "c1": 
                        if(hpint<1)
                        {
                           lose(); 
                        }
                        else
                        {
                            Combat1();
                        }
                    break;
                } break;
                
            case "inspectS":
                switch (playerChoice)
                {
                    case "c1": Combat1(); break;
                } break;
                
                case "playerCombatO":
                switch(playerChoice)
                {
                    case "c1": 
                        if(enemyHPS<1)
                        {
                            win();
                        }
                        else
                        {
                            enemyCombatO();
                        }
                     break;
                } break;
            
            case "enemyCombatO":
                switch(playerChoice)
                {
                    case "c1": 
                        if(hpint<1)
                        {
                           lose(); 
                        }
                        else
                        {
                            Combat1();
                        }
                    break;
                } break;
                
            case "inspectO":
                switch (playerChoice)
                {
                    case "c1": Combat1(); break;
                } break;