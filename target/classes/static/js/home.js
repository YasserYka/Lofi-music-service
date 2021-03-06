const AudioContext = window.AudioContext || window.webkitAudioContext;
const audioContext = new AudioContext();
let audio, audioTag;

let imageClass = document.getElementsByClassName('image');

for(let i = 0; i < imageClass.length; i++){
  imageClass[i].onclick = () => {fetchAudio(imageClass[i].dataset.url);};
}

function play(){
    const bufferSource = audioContext.createBufferSource();
    bufferSource.buffer = audio;
    bufferSource.start();
    streamDestination = audioContext.createMediaStreamDestination();
    bufferSource.connect(streamDestination);
    if(typeof audioTag === 'undefined')
      createAndAppendAudioTag(streamDestination);
    else
      changeSrcObject(streamDestination);
}

function createAndAppendAudioTag(streamDestination){
  audioTag = new Audio();
  audioTag.controls = true;
  audioTag.autoplay = true;
  audioTag.id = 'audioPLayer';
  document.body.appendChild(audioTag);
  audioTag.srcObject = streamDestination.stream;
}

function changeSrcObject(streamDestination){audioTag.srcObject = streamDestination.stream;}

function fetchAudio(url){
  fetch(url)
      .then(data => data.arrayBuffer())
      .then(buffer => audioContext.decodeAudioData(buffer))
      .then(decodeAudio => {audio = decodeAudio;})
      .then(() => {play(url);})
}
